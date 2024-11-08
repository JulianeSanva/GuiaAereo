/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AulaInvertida;

/**
 *
 * @author Juliane
 */
import java.util.List;

public class ResultadoCaminho {
    private List<Integer> caminho;
    private int custoTotal;

    public ResultadoCaminho(List<Integer> caminho, int custoTotal) {
        this.caminho = caminho;
        this.custoTotal = custoTotal;
    }

    public List<Integer> getCaminho() {
        return caminho;
    }

    public int getPercursoTotal() {
        return custoTotal;
    }
}