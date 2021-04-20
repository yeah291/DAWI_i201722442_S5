package com.ciberfarma.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.ciberfarma.model.Usuario;

public class FrmMantUsuario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JLabel lblCodigo;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblClave;
	private JLabel lblFecha;
	private JLabel lblTipo;
	private JLabel lblEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantUsuario frame = new FrmMantUsuario();
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
	public FrmMantUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(29, 129, 46, 14);
		contentPane.add(lblUsuario);
		
		lblNewLabel = new JLabel("Mantenimiento de usuarios");
		lblNewLabel.setBounds(29, 11, 164, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 33, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 64, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(85, 95, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(85, 126, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(85, 157, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(85, 188, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(85, 216, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(85, 247, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(304, 58, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(304, 94, 89, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(304, 125, 89, 23);
		contentPane.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(304, 156, 89, 23);
		contentPane.add(btnConsultar);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(29, 36, 46, 14);
		contentPane.add(lblCodigo);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(29, 98, 46, 14);
		contentPane.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 67, 46, 14);
		contentPane.add(lblNombre);
		
		lblClave = new JLabel("Clave");
		lblClave.setBounds(29, 160, 46, 14);
		contentPane.add(lblClave);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(29, 191, 46, 14);
		contentPane.add(lblFecha);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(29, 219, 46, 14);
		contentPane.add(lblTipo);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(29, 250, 46, 14);
		contentPane.add(lblEstado);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
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
		// grabar el objeto
		// 1. fabricar el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = new Usuario();
		//u.setCodigo(4);
		u.setNombre(txtNombre.getText());
		u.setApellido(txtApellido.getText());
		u.setUsuario(txtUsuario.getText());
		u.setClave(txtClave.getText());
		u.setFnacim(txtFecha.getText());
		u.setTipo(Integer.parseInt(txtTipo.getText()));
		u.setEstado(Integer.parseInt(txtEstado.getText()));
		
		// 3. empezar mi transacción
		em.getTransaction().begin();
		// proceso a realizar (persistencia)
		//em.persist(u);
		em.persist(u);
		// 4. confirmar la transacción
		em.getTransaction().commit();
		// 5. cerrar transaccion
		em.close();
		fabrica.close();
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		Consultar();
	}

	private void Consultar() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		// 3. consulta
		
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));
		if(u != null) {
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtUsuario.setText(u.getUsuario());
			txtClave.setText(u.getClave());
			txtFecha.setText(u.getFnacim());
			txtTipo.setText(""+u.getTipo());
			txtEstado.setText(""+u.getEstado());
		}else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
		}
		// 5. cerrar transaccion
		em.close();
		fabrica.close();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		Actualizar();
		Limpiar();
	}

	private void Limpiar() {
		// TODO Auto-generated method stub
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtFecha.setText("");	
		txtTipo.setText("");
		txtEstado.setText("");
	}

	private void Actualizar() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));
		
		if(u != null){
		
			
			u.setNombre(txtNombre.getText());
			u.setApellido(txtApellido.getText());
			u.setUsuario(txtUsuario.getText());
			u.setClave(txtClave.getText());
			u.setFnacim(txtFecha.getText());
			u.setTipo(Integer.parseInt(txtTipo.getText()));
			u.setEstado(Integer.parseInt(txtEstado.getText()));
			
			// proceso a realizar (persistencia)
			//em.persist(u);
			em.merge(u);
			// 4. confirmar la transacción
			em.getTransaction().commit();
			
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");
		}else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
		}
		em.close();
		fabrica.close();
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Eliminar();
		Limpiar();
	}

	private void Eliminar() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
		EntityManager em = fabrica.createEntityManager();
		try {
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		}catch(Exception e){
			em.close();
			fabrica.close();
		}
		
	}
}
