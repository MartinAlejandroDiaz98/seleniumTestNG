package tests.sauceDemo;

import org.testng.annotations.Test;

public class GrupoTest {
    @Test(groups = "probando")
    public void testGrupo(){
        System.out.println("Funciona!");
    }
    
}
