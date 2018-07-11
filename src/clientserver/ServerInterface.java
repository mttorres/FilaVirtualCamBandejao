/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

import database.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mywebcam.Person;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Mateus
 */
public class ServerInterface extends javax.swing.JFrame {
    
	public void atualizaInterface(Driver driver) throws FileNotFoundException, SQLException, IOException
	{
		ArrayList<Person> l = new ArrayList<Person>();
        try
        {
            for(Object em: (ArrayList) driver.getAll() ) // teremos a lista com todos os estudantes
            {
                l.add((Person) em); // e a variavel em pega cada um e salva na nova lista
            }
        }catch(SQLException ex)
        {
            // whatever
        }
        // custom table ou d table
        DefaultTableModel amod = new DefaultTableModel(); //usamos isso para facilitar nosso acesso
        Object[] tableColumnNames = new Object[1]; // 
        tableColumnNames[0] = "ID";
        amod.setColumnIdentifiers(tableColumnNames); // colocando eles como identificadores de coluna
        Object[] objects = new Object[1]; // note que precisa ser object por padrao tambem
        if(l.size() > 0) // se a lista nao esta vazia
        {
            for(int i = 0; i < l.size(); i++)
            {
                Person dv = l.get(i); // pegamos o estudante da vez o nome � apenas figurativo
                objects[0] = Integer.toString(dv.getId());
                amod.addRow(objects); // adiciona a nossa linha a tabela! onde essa tabela sempre recebe arrays por padrao
            }
        }
        this.table.setModel(amod); // colocamos a tabela para ser oque o "formato de amod"
    }

 
    /**
     * Creates new form ServerInterface
     * @throws IOException 
     * @throws SQLException 
     */
    public ServerInterface() throws SQLException, IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException 
     * @throws SQLException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException, IOException {
    	System.out.println("INICIALIZANDO INTERFACE");
    	jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Driver driver = new Driver(); 
        ArrayList<Person> l = new ArrayList<Person>();
        int nalunos = l.size();
        System.out.println("ALUNOS ANTES DE LOAD: "+nalunos);
        l = driver.getAll();
        nalunos = l.size();
        System.out.println("ALUNOS  DEPOIS DE LOAD: "+nalunos);
        Object linhascol [][] = new Object [25][1];
        Object[] ColumnNames = new Object[1]; //
        ColumnNames[0] = "Matriculas: ";
        System.out.println("INICIALIZANDO tabela");
        int i =0;
        int j =0;
        for(j = 0; j < l.size(); j++)
        {
        	
        	Person davez = l.get(j);
        	linhascol[i][0] = davez.getId();
        	i++;
        }
     //  DefaultTableModel amod = new DefaultTableModel(linhascol,ColumnNames);
       table = new JTable();
 //      amod.setColumnIdentifiers(ColumnNames);
    //   table.setModel(amod);
       table.setModel(new DefaultTableModel(
        		linhascol
        		,
        		new String [] {
                        "Matriculas: "
                    }
            ) {
                
				private static final long serialVersionUID = 1L;
				boolean[] canEdit = new boolean [] {
                    false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
                  
        
        jButton1.setText("PR�XIMO!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jTextField1.setEditable(false);
        jTextField1.setText("Proximo a entrar :");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        System.out.println("INICIALIZANDO LABEL");
        label = new JLabel("");
        //String imgpath = driver.getFirstImg().getAbsolutePath();        
        //System.out.println(imgpath);
        if(driver.getFirstImg() != null)
        {
        	String imgpath = driver.getFirstImg().getAbsolutePath();
        	File f = new File(imgpath);
        	ImageIcon ic = new ImageIcon(f.getPath());
            try
            {
            	
            	label.setIcon(ic);
            	
            	
            }catch(Exception e)
            {
            	System.out.println("ERRO AO AO ADICIONAR ICONE "+e);
            }
        }
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(jButton1))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(label, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
        			.addComponent(table, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(table, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(label, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
        					.addComponent(jButton1)
        					.addGap(51))))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
        	System.out.println("BOTAO ATIVADO");
        	Driver driver = new Driver();
            driver.deletePerson();
            this.setVisible(false);
            this.atualizaInterface(driver);
            
            
            ArrayList <Person> l = driver.getAll();
            int num = l.size();
            
            if(num != 0)
            {
                //MODIFICADO POR MATEUS
            	String imgpath = driver.getFirstImg().getAbsolutePath();
            	System.out.println("DIRETORIO DA IMAGEM NOVA: "+imgpath);
                System.out.println("PESSOAS NA LISTA: "+num);
            	try
                {
                	System.out.println("A imagem existe? "+ driver.getFirstImg().exists());
                	
                	ImageIcon imgIcon = new ImageIcon(imgpath);
                	label.setIcon(imgIcon);        
                	
                	System.out.println("***************************");                	                	
                	                	
                	
                	
                }catch(Exception e)
                {
                	System.out.println("ERRO AO AO ADICIONAR ICONE "+e);
                }
            }
            else
            {
            	this.label.removeAll();
            }
            this.setVisible(true);  
       //     this.setVisible(false);
          // initComponents();
       //     this.setVisible(true);
            
        }catch(SQLException EX)
        {
            System.err.println("ERRO AO TENTAR REMOVER DA TABELA SQL" + EX);
        } catch (IOException ex) {
            Logger.getLogger(ServerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     * @throws SQLException 
     */
    public static void main(String args[]) throws IOException, SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
      //  java.awt.EventQueue.invokeLater(new Runnable() {
       //     public void run() {
            //    new ServerInterface().setVisible(true);
          //  }
       // });
        ServerSocket servidor = new ServerSocket(12345); 
		System.out.println("Porta 12345 ABERTA!\n");
		
		Queue<Person> fila = new LinkedList<Person>(); 
		Driver driver = new Driver();
		webPage page = new webPage();
		String picName = "test";
               // ServerInterface server = new ServerInterface();
		int i = 0;
		while (true){
			System.out.println("laço while e try\n");
            ServerInterface server = new ServerInterface();
            server.setVisible(true);
            try {
                                
                                
				
                                /***** MODIFICADO POR BRUNO *****/
				 Socket cliente = servidor.accept(); 
				 
				 System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());				 				
				 
				 InputStream inputStream = cliente.getInputStream();
				 ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				 String personId = Integer.toString(objectInputStream.readInt());				 
				 long size =objectInputStream.readLong();
				 
				 FileOutputStream fos = new FileOutputStream("html/imgs/"+personId+".jpg");
				 byte[] buf = new byte[4096];
	                while(true){
	                    int len = objectInputStream.read(buf);
	                    if(len == -1) break;
	                    
	                    fos.write(buf, 0, len);
	                }
                 fos.flush();
                 fos.close();
                 System.out.println("Transferência concluída com sucesso! Imagem em: "+personId);
				 System.out.println("Matricula: "+personId+" entrou na fila.");
				 
				 if(Integer.parseInt(personId)==987654321)
				 {
					 break;
				 }
				 
				 //note que nesse caso de teste estamos registrando alunos inves de 
				 //buscar as informa��es existentes pela matricula/nome digitada
				 
				 

				 /********************MODIFICADO POR MATEUS*******************/
				 System.out.println(driver.repetido(Integer.parseInt(personId)));
				 if(driver.repetido(Integer.parseInt(personId))) {	 
				 	 System.out.println("MATRICULA INVALIDA, ALUNO J� ESTA NA FILA");
					 // nao inserimos ninguem na tabela do bd
				 }
				 /********************MODIFICADO POR MATEUS*******************/
				 else
				 {
					 Person a1 = new Person(Integer.parseInt(personId), new File("html/imgs/"+personId+".jpg")); // instanciamos um aluno com os dados coletados
					 fila.add(a1); // salvamos na fila
					 System.out.println("Aluno adicionado, existem:  " + (fila.size()-1) + " aluno(s) na sua frente");
					 System.out.println("Matricula dele: "+a1.getId()+"path de seu arquivo imagem: "+a1.getPic().getPath());
					 driver.insertPerson(a1);
					 page.insertPerson(a1);
					
					 System.out.println();
					 System.out.println("F I L A ");
					 System.out.println();
					 for( Person a: fila)
					 {
						 System.out.println(a);
					 }
					 inputStream.close();
					 objectInputStream.close();				 				 
					 cliente.close(); // fechamamos nosso cliente para ir para o proximo
				 }
				 
                 
			} catch (Exception e){
				e.printStackTrace();
			}
			server.setVisible(false);    
                
        }
		fila.clear();
		System.out.println("S E R V I D O R     F E C H A D O ");
		servidor.close();
    
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    
   
    private javax.swing.JButton jButton1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private JTable table;
    private JLabel label;
   
    // End of variables declaration//GEN-END:variables
 public  JTable getJ()
 {
     return this.table;
 }
 public JLabel getL()
 {
	 return this.label;
 }
}
