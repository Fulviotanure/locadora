/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author sala308b
 */
public class filmes {
 private int codigo;
    private String titulo;
    private int cod_genero;
    private String sinopse;
    private String diretor;
    private int ano_lancamento;
    private String status;
    private String usuario_cadastro;
    private Date datahora_cadastro;

    public filmes() {
    }

    public filmes(int codigo, String titulo, int cod_genero, String sinopse, String diretor, int ano_lancamento, String status, String usuario_cadastro, Date datahora_cadastro) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.cod_genero = cod_genero;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.ano_lancamento = ano_lancamento;
        this.status = status;
        this.usuario_cadastro = usuario_cadastro;
        this.datahora_cadastro = datahora_cadastro;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the cod_genero
     */
    public int getCod_genero() {
        return cod_genero;
    }

    /**
     * @param cod_genero the cod_genero to set
     */
    public void setCod_genero(int cod_genero) {
        this.cod_genero = cod_genero;
    }

    /**
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the ano_lancamento
     */
    public int getAno_lancamento() {
        return ano_lancamento;
    }

    /**
     * @param ano_lancamento the ano_lancamento to set
     */
    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the usuario_cadastro
     */
    public String getUsuario_cadastro() {
        return usuario_cadastro;
    }

    /**
     * @param usuario_cadastro the usuario_cadastro to set
     */
    public void setUsuario_cadastro(String usuario_cadastro) {
        this.usuario_cadastro = usuario_cadastro;
    }

    /**
     * @return the datahora_cadastro
     */
    public Date getDatahora_cadastro() {
        return datahora_cadastro;
    }

    /**
     * @param datahora_cadastro the datahora_cadastro to set
     */
    public void setDatahora_cadastro(Date datahora_cadastro) {
        this.datahora_cadastro = datahora_cadastro;
    }
    
        
    
    
    
}
