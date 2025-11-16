import React from "react";
import styles from "./Input.module.css"; 

type InputProps = {
  label: string;
  type?: string;
  value: string;
  onChange: (value: string) => void;
};

const Input: React.FC<InputProps> = ({ label, type = "text", value, onChange }) => {
  return (
    <div className={styles.inputContainer}>
      <label>{label}</label>
      <input
        type={type}
        value={value}
        onChange={e => onChange(e.target.value)}
      />
    </div>
  );
};

export default Input;