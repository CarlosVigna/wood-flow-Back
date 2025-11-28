package com.wecode.wood_flow.controller;


import com.wecode.wood_flow.dto.request.BomRequestDTO;
import com.wecode.wood_flow.dto.request.EtapaMateriaisRequestDTO;
import com.wecode.wood_flow.dto.request.ProdutoEtapaRequestDTO;
import com.wecode.wood_flow.dto.request.ProdutosRequestDTO;
import com.wecode.wood_flow.dto.response.BomResponseDTO;
import com.wecode.wood_flow.dto.response.EtapaMateriaisResponseDTO;
import com.wecode.wood_flow.dto.response.ProdutoEtapaResponseDTO;
import com.wecode.wood_flow.dto.response.ProdutosResponseDTO;
import com.wecode.wood_flow.entity.produtos.Bom;
import com.wecode.wood_flow.entity.produtos.EtapaMateriais;
import com.wecode.wood_flow.entity.produtos.ProdutoEtapa;
import com.wecode.wood_flow.entity.produtos.Produtos;
import com.wecode.wood_flow.service.ProdutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final ProdutosService service;

    public ProdutosController (ProdutosService service) {
        this.service = service;
    }

    @PostMapping ("/adicionar")
    public ResponseEntity<ProdutosResponseDTO> adicionar(@RequestBody ProdutosRequestDTO dto){
        ProdutosResponseDTO novo = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ProdutosResponseDTO> buscarPorId(@PathVariable Long id){
        ProdutosResponseDTO produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping ("/buscaTodos")
    public ResponseEntity<List<ProdutosResponseDTO>> buscarTodos(){
        List<ProdutosResponseDTO> listaProdutos = service.buscarTodos();
        return ResponseEntity.ok(listaProdutos);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ProdutosResponseDTO> alterar(@PathVariable Long id, @RequestBody ProdutosRequestDTO dto){
        ProdutosResponseDTO alterado = service.atualizar(id, dto);
        return ResponseEntity.ok(alterado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/etapas")
    public ResponseEntity<ProdutoEtapaResponseDTO> adicionarEtapa(@PathVariable Long id, @RequestBody ProdutoEtapaRequestDTO dto) {

        ProdutoEtapa etapa = service.adicionarEtapa(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProdutoEtapaResponseDTO(etapa));
    }

    @PostMapping("/componentes")
    public ResponseEntity<BomResponseDTO> adicionarComponente(
            @RequestBody BomRequestDTO dto) {

        Bom componente = service.adicionarComponente(
                dto.idPai(),
                dto.idFilho(),
                dto.quantidade()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new BomResponseDTO(componente));
    }

    @PostMapping("/{idPai}/{idEtapa}/{idFilho}/materialEtapa")
    public ResponseEntity<EtapaMateriaisResponseDTO> adicionarComponenteEtapa(
            @PathVariable Long idPai, @PathVariable Long idEtapa, @PathVariable Long idFilho, @RequestBody EtapaMateriaisRequestDTO dto){
        EtapaMateriais material = service.adicionarMaterialEtapa(idPai, idEtapa, idFilho, dto.quantidade());
        return ResponseEntity.status(HttpStatus.CREATED).body(new EtapaMateriaisResponseDTO(material));
    }

    @DeleteMapping("/{idPai}/{idEtapa}/removerEtapa")
    public ResponseEntity<Void> removerEtapa(@PathVariable Long idPai, @PathVariable Long idEtapa){
        service.removerEtapa(idPai, idEtapa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPai}/{idFilho}/removerComponente")
    public ResponseEntity<Void> removerComponente(@PathVariable Long idPai, @PathVariable Long idFilho){
        service.removerComponente(idPai, idFilho);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPai}/{idEtapa}/{idFilho}/removerMaterialEtapa")
    public ResponseEntity<Void> removerMaterialEtapa(@PathVariable Long idPai, @PathVariable Long idEtapa, @PathVariable Long idFilho){
        service.removerMaterialEtapa(idPai, idEtapa, idFilho);
        return ResponseEntity.noContent().build();
    }
}
