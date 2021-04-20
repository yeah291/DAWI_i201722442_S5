package com.ciberfarma.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ciberfarma.model.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantProveedor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoProveedor;
	private JLabel lblIdProveedor;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblMail;
	private JTextField txtIdProveedor;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantProveedor frame = new FrmMantProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMantProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoProveedor = new JLabel("Mantenimiento proveedor");
		lblMantenimientoProveedor.setBounds(10, 11, 166, 14);
		contentPane.add(lblMantenimientoProveedor);
		
		lblIdProveedor = new JLabel("id proveedor");
		lblIdProveedor.setBounds(10, 36, 84, 14);
		contentPane.add(lblIdProveedor);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 67, 84, 14);
		contentPane.add(lblNombre);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 98, 84, 14);
		contentPane.add(lblTelefono);
		
		lblMail = new JLabel("E-Mail");
		lblMail.setBounds(10, 129, 84, 14);
		contentPane.add(lblMail);
		
		txtIdProveedor = new JTextField();
		txtIdProveedor.setBounds(104, 33, 86, 20);
		contentPane.add(txtIdProveedor);
		txtIdProveedor.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(104, 64, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(104, 95, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(104, 126, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(335, 63, 89, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(335, 94, 89, 23);
		contentPane.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(335, 125, 89, 23);
		contentPane.add(btnConsultar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		Registrar();
	}

	private void Registrar() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		
		EntityManager em = fabrica.createEntityManager();
		
		Proveedor p = new Proveedor();
		
		//p.setCodigo(0);
		p.setNombre(txtNombre.getText());
		p.setTelefono(txtTelefono.getText());
		p.setEmail(txtCorreo.getText());
		
		// 3. empezar mi transacción
		em.getTransaction().begin();
		// proceso a realizar (persistencia)
		//em.persist(u);
		em.merge(p);
		// 4. confirmar la transacción
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		Actualizar();
	}

	private void Actualizar() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		EntityManager em = fabrica.createEntityManager();
		
		Proveedor p = em.find(Proveedor.class, Integer.parseInt(txtIdProveedor.getText()));
		
		if(p != null) {
			p.setNombre(txtNombre.getText());
			p.setTelefono(txtTelefono.getText());
			p.setEmail(txtCorreo.getText());
			
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
		}else{
			JOptionPane.showMessageDialog(this, "No existe proveedor");
		}
		em.close();
		fabrica.close();
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Eliminar();
	}

	private void Eliminar() {
		// TODO Auto-generated method stub
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		EntityManager em = fabrica.createEntityManager();
		
		
		try {
			Proveedor p = em.find(Proveedor.class, Integer.parseInt(txtIdProveedor.getText()));
			
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();	
		} catch (Exception e2) {
			// TODO: handle exception
			em.close();
			fabrica.close();
		}
	}
	
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		EntityManager em = fabrica.createEntityManager();
		
		Proveedor p = em.find(Proveedor.class, Integer.parseInt(txtIdProveedor.getText()));
		if(p != null) {
			txtNombre.setText(p.getNombre());
			txtTelefono.setText(p.getTelefono());
			txtCorreo.setText(p.getEmail());
			
			
		}else {
			JOptionPane.showMessageDialog(this, "No existe proveedor");
		}
		em.close();
		fabrica.close();
	}
}
