package com.wecode.wood_flow.service;

import com.wecode.wood_flow.dto.request.ProdutoEtapaRequestDTO;
import com.wecode.wood_flow.dto.request.ProdutosRequestDTO;
import com.wecode.wood_flow.dto.response.ProdutosResponseDTO;
import com.wecode.wood_flow.entity.produtos.*;
import com.wecode.wood_flow.repositories.BomRepository;
import com.wecode.wood_flow.repositories.EtapasRepository;
import com.wecode.wood_flow.repositories.ProdutoEtapaRepository;
import com.wecode.wood_flow.repositories.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutosRepository repository;
    private final EtapasRepository etapasRepository;
    private final ProdutoEtapaRepository produtoEtapaRepository;
    private final BomRepository bomRepository;



    public Produtos buscarEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProdutosResponseDTO buscarPorId(Long id){
        return new ProdutosResponseDTO(buscarEntity(id));
    }

    public List<ProdutosResponseDTO> buscarTodos(){
        return repository.findAll()
                .stream().map(ProdutosResponseDTO::new).toList();
    }



    public ProdutosResponseDTO criar(ProdutosRequestDTO dto) {
        Produtos produto = new Produtos();

        produto.setDescricao(dto.descricao());
        produto.setTipo(dto.tipo());
        produto.setUnidMedida(dto.unidMedida());
        produto.setCusto(dto.custo());
        produto.setUltimoCusto(dto.ultimoCusto());
        produto.setEstoqueMinimo(dto.estoqueMinimo());
        produto.setLocalEstoque(dto.localEstoque());
        produto.setCor(dto.cor());
        produto.setPrecoA(dto.precoA());
        produto.setPrecoB(dto.precoB());
        produto.setAltura(dto.altura());
        produto.setLargura(dto.largura());
        produto.setProfundidade(dto.profundidade());

        Produtos salvo = repository.save(produto);
        return new ProdutosResponseDTO(salvo);
    }

    public ProdutosResponseDTO atualizar(Long id, ProdutosRequestDTO dto) {

        Produtos produto = buscarEntity(id);

        produto.setDescricao(dto.descricao());
        produto.setTipo(dto.tipo());
        produto.setUnidMedida(dto.unidMedida());
        produto.setCusto(dto.custo());
        produto.setUltimoCusto(dto.ultimoCusto());
        produto.setEstoqueMinimo(dto.estoqueMinimo());
        produto.setLocalEstoque(dto.localEstoque());
        produto.setCor(dto.cor());
        produto.setPrecoA(dto.precoA());
        produto.setPrecoB(dto.precoB());
        produto.setAltura(dto.altura());
        produto.setLargura(dto.largura());
        produto.setProfundidade(dto.profundidade());

        Produtos atualizado = repository.save(produto);

        return new ProdutosResponseDTO(atualizado);
    }

    public ProdutoEtapa adicionarEtapa(Long idProduto, ProdutoEtapaRequestDTO dto) {

        Produtos produto = buscarEntity(idProduto);

        Etapas etapa = etapasRepository.findById(dto.idEtapa())
                .orElseThrow(() -> new RuntimeException("Etapa não encontrada"));

        ProdutoEtapa pe = new ProdutoEtapa(
                produto,
                etapa,
                dto.ordem(),
                dto.setor(),
                dto.tempoPrevisto()
        );

        return produtoEtapaRepository.save(pe);
    }


    public Bom adicionarComponente(Long idPai, Long idFilho, BigDecimal quantidade) {

        Produtos pai = buscarEntity(idPai);
        Produtos filho = buscarEntity(idFilho);

        Bom bom = new Bom();

        BomId bomId = new BomId(idPai, idFilho);
        bom.setId(bomId);

        bom.setProdutoPai(pai);
        bom.setProdutoFilho(filho);

        bom.setQuantidade(quantidade);

        return bomRepository.save(bom);
    }


    public EtapaMateriais adicionarMaterialEtapa(Long idProduto, Long idEtapa,Long idProdutoFilho, BigDecimal quantidade) {

        ProdutoEtapa produtoEtapa = produtoEtapaRepository.findById(new ProdutoEtapaId(idProduto, idEtapa))
                .orElseThrow(() -> new RuntimeException("ProdutoEtapa não encontrada"));

        Produtos produtoFilho = buscarEntity(idProdutoFilho);

        EtapaMateriaisId id = new EtapaMateriaisId(idProduto, idEtapa, idProdutoFilho);

        EtapaMateriais mat = new EtapaMateriais();
        mat.setId(id);
        mat.setProdutoEtapa(produtoEtapa);
        mat.setProdutoFilho(produtoFilho);
        mat.setQuantidade(quantidade);

        produtoEtapa.getMateriais().add(mat);

        produtoEtapaRepository.save(produtoEtapa);

        return mat;
    }



    public void removerEtapa(Long idProduto, Long idEtapa){
        ProdutoEtapaId id = new ProdutoEtapaId(idProduto, idEtapa);
        ProdutoEtapa pe = produtoEtapaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vínculo produto-etapa não existe"));

        produtoEtapaRepository.delete(pe);
    }


    public void removerComponente(Long idProdutoPai, Long idProdutoFilho){
        BomId id = new BomId(idProdutoPai, idProdutoFilho);

        Bom bom = bomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Componente não existe no BOM"));

        bomRepository.delete(bom);
    }



    public void removerMaterialEtapa(Long idProduto, Long idEtapa, Long idProdutoFilho){

        EtapaMateriaisId id = new EtapaMateriaisId(idProduto, idEtapa, idProdutoFilho);

        ProdutoEtapa pe = produtoEtapaRepository.findById(new ProdutoEtapaId(idProduto, idEtapa))
                .orElseThrow(() -> new RuntimeException("ProdutoEtapa não encontrada"));

        pe.getMateriais().removeIf(m -> m.getId().equals(id));

        produtoEtapaRepository.save(pe);
    }


    public void deletarProduto(Long id){

        Produtos produto = buscarEntity(id);

        boolean usadoComoPai = bomRepository.existsByProdutoPai(produto);
        boolean usadoComoFilho = bomRepository.existsByProdutoFilho(produto);

        boolean usadoEmEtapa = produtoEtapaRepository.existsByProduto(produto);

        if (usadoComoPai || usadoComoFilho || usadoEmEtapa){
            throw new RuntimeException("Produto não pode ser deletado pois está vinculado.");
        }

        repository.delete(produto);
    }
}
