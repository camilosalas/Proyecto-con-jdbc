/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import com.test.conexion.conMySQL;
import com.test.dto.ClienteDTO;
//import com.test.dto.ClientesDTO;
import com.test.dto.VendedorDTO;
import com.test.negocio.ClientesNG;
//import com.test.negocio.ClientesNG;
import com.test.negocio.VendedorNG;
import java.sql.Connection;

/** 
 *
 * @author CAMILO SALAS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Main m = new Main();
    m.TestConection();
    //m.TestValidarUsuario();
    //m.TestAgregarClientes();
        
    }
    //private Object cg;
    
    
    public void TestConection(){
               
        
        
        if(conMySQL.getConexion() == null){
            System.out.println("No hay Conexion");
        }else{
            System.out.println("Conexion Exitosa");
        }
    }
    
    public void TestValidarUsuario(){
        VendedorNG vg = new VendedorNG();
        VendedorDTO vdto = new VendedorDTO();
        vdto = vg.validarVendedor("Camilo", "111");
        System.out.println(vdto.getID_VENDEDOR()+" | "+vdto.getUSUARIO()+" | "+vdto.getROL());
    }

    //private void TestAgregarVendedor() {
    //    VendedorDTO vdto = new VendedorDTO();
    //    vdto.setUSUARIO("Luz");
    //    vdto.setCLAVE("555");
    //    vdto.setROL("admin");
  
       
    //     VendedorNG vg = new VendedorNG();
        //vg.agregarVendedor(vdto);  
    //    if (vg.agregarVendedor(vdto)) {
            
    //        System.out.println("SE INGRESO CORRECTAMENTE");
            
    //    } else {
            
    //        System.out.println("OCURRIÓ UN ERROR AL INSERTAR");
    //    }
    
    
    
    private void TestAgregarClientes() {
        ClienteDTO cdto = new ClienteDTO();
        cdto.setNombres("Camilo");
        cdto.setAppaterno("Salas");
        cdto.setDni("34567");
  
       
         ClientesNG cg = new ClientesNG();
        //vg.agregarVendedor(vdto);  
        if (cg.agregarCliente(cdto)) {
            
            System.out.println("SE INGRESO CORRECTAMENTE");
            
        } else {
            
            System.out.println("OCURRIÓ UN ERROR AL INSERTAR");
        }
    }
}    
  
