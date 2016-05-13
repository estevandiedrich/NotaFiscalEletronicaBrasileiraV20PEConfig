package br.com.hs.nfe.pe.ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.jvnet.substance.skin.SubstanceSaharaLookAndFeel;

import br.com.hs.nfe.pe.conf.Config;
import br.com.hs.nfe.pe.util.GifFileFilter;
import br.com.hs.nfe.pe.util.XMLFileFilter;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class IntegrationUI extends JFrame {

	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger( IntegrationUI.class );

    private CellConstraints cellConstraints = null;

    private FormLayout layout = null;

    private JPanel pnConnection = null;
    private JPanel pn = null;
    private JPanel pnFSDA = null;
    private JPanel pnButtons = null;
    private JScrollPane scrollPane = null;
    
    protected JTabbedPane pnTabs = null;

    private JLabel lbThreadSleep = null;
    private JLabel lbLogo = null;
    private JLabel lbCaminhoXML = null;
    private JLabel lbPortaRMI = null;
    private JLabel lbOrientacaoDanfe = null;
    private JLabel lbPastaDanfe = null;
    private JLabel lbPastaDanfeFSDA = null;
    private JLabel lbNroPaginas = null;
    private JLabel lbNroPaginasFSDA = null;
    private JLabel lbImpressora = null;
    private JLabel lbImpressoraFSDA = null;
    private JLabel lbLogoDanfe = null;
    private JLabel lbXmlCompactado = null;
    private JLabel lbXmlCompactadoFSDA = null;
    private JLabel lbXmlProcessado = null;
    private JLabel lbXmlProcessadoFSDA = null;
    private JLabel lbRazaoSocial = null;
    private ButtonGroup bgRetratoPaisagem = null;
    private JButton lupaXML = null;
    private JButton lupaDanfes = null;
    private JButton lupaDanfesFSDA = null;
    private JButton lupaLogoDanfe = null;
    private JButton lupaXMLCompactados = null;
    private JButton lupaXMLCompactadosFSDA = null;
    private JButton lupaXMLProcessados = null;
    private JButton lupaXMLProcessadosFSDA = null;
    private JButton salvar = null;
    private JButton fechar = null;
    
    private JFileChooser jFileChooserXML = null;
    private JFileChooser jFileChooserPastas = null;
    private JFileChooser jFileChooserLogo = null;

    private JTextField tfThreadSleep = null;
    private JTextField tfCaminhoXML = null;
    private JTextField tfPastaDanfe = null;
    private JTextField tfPastaDanfeFSDA = null;
    private JTextField tfPortaRMI = null;
    private JTextField tfNroPaginas = null;
    private JTextField tfNroPaginasFSDA = null;
    private JTextField tfImpressora = null;
    private JTextField tfImpressoraFSDA = null;
    private JTextField tfLogoDanfe = null;
    private JTextField tfXmlCompactado = null;
    private JTextField tfXmlCompactadoFSDA = null;
    private JTextField tfXmlProcessado = null;
    private JTextField tfXmlProcessadoFSDA = null;
    private JTextField tfRazaoSocial = null;
    
    private JRadioButton rbRetrato = null;
    private JRadioButton rbPaisagem = null;

    public IntegrationUI() 
    {
		super.setTitle( "Configurações" );
		super.setLayout( new FlowLayout() );
		try {
		    UIManager.setLookAndFeel( new SubstanceSaharaLookAndFeel() );
		} catch ( Exception e ) {
		    logger.error( e );
		}
		super.setDefaultCloseOperation( EXIT_ON_CLOSE );

		this.initComponents();
		this.loadProperties();
		
		super.setSize( 460, 460 );

		super.setLocationRelativeTo( null );
		super.setResizable( false );
		super.setVisible(true);
		super.getContentPane().add( this.pnTabs, BorderLayout.CENTER );
    }
    private void initComponents()
    {
    	this.pnTabs = new JTabbedPane();
    	
    	this.cellConstraints = new CellConstraints();
    	
		this.layout = new FormLayout( "10px, 120px, 70px, 190px, 40px",//cols
										"10px, 21px, 21px, 21px, 21px, 21px, 21px, 21px, 21px, 21px, 21px, 21px, 10px" );//rows
	
		this.pnConnection = new JPanel( this.layout );

		this.pn = new JPanel(new BorderLayout());
		this.pn.setName("Configurações gerais");
		this.scrollPane = new JScrollPane( this.pnConnection );
		this.pn.add( this.scrollPane , BorderLayout.CENTER);
		
		this.pnFSDA = new JPanel(this.layout);
		this.pnFSDA.setName("Configurações FSDA");
		
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/logo-hs.jpg" ));
		
		this.lbLogo = new JLabel();
		this.lbLogo.setIcon( new ImageIcon( imageIcon.getImage().getScaledInstance( 460, 88, Image.SCALE_SMOOTH ) ));
		
		this.getContentPane().add(lbLogo,BorderLayout.NORTH);
		
		this.lbThreadSleep = new JLabel( "Dormir por: " );
		this.lbCaminhoXML = new JLabel( "XML Configuração: " );
		this.lbOrientacaoDanfe = new JLabel( "Orientação Danfe: " );
		this.lbPortaRMI = new JLabel( "Porta RMI: " );
		this.lbPastaDanfe = new JLabel( "Pasta Danfes: " );
		this.lbPastaDanfeFSDA = new JLabel( "Pasta Danfes FSDA: " );
		this.lbNroPaginas = new JLabel( "Número de cópias: " );
		this.lbNroPaginasFSDA = new JLabel( "Número de cópias FSDA : " );
		this.lbImpressora = new JLabel( "Impressora: " );
		this.lbImpressoraFSDA = new JLabel( "Impressora FSDA: " );
		this.lbLogoDanfe = new JLabel( "Logo danfe: " );
		this.lbXmlCompactado = new JLabel( "XML Compactado: " );
		this.lbXmlCompactadoFSDA = new JLabel( "XML Compactado FSDA: " );
		this.lbXmlProcessado = new JLabel( "XML Processado: ");
		this.lbXmlProcessadoFSDA = new JLabel( "XML Processado FSDA: ");
		this.lbRazaoSocial = new JLabel( "Razão Social: " );
		
		this.rbRetrato = new JRadioButton("Retrato");
		this.rbRetrato.setToolTipText("Selecionando esta opção você estará definindo o DANFE em formato Retrato");
		this.rbPaisagem = new JRadioButton("Paisagem");
		this.rbPaisagem.setToolTipText("Selecionando esta opção você estará definindo o DANFE em formato Paisagem");
		
		this.rbRetrato.addActionListener(new RadioButtonActionListener());
		this.rbPaisagem.addActionListener(new RadioButtonActionListener());
		
		this.bgRetratoPaisagem = new ButtonGroup();
		this.bgRetratoPaisagem.add(rbRetrato);
		this.bgRetratoPaisagem.add(rbPaisagem);
		
		this.lupaXML = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaDanfes = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaDanfesFSDA = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaLogoDanfe = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaXMLCompactados = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaXMLCompactadosFSDA = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaXMLProcessados = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.lupaXMLProcessadosFSDA = new JButton(new ImageIcon( new ImageIcon( ClassLoader.getSystemResource( "br/com/hs/nfe/pe/ui/imagens/examine.png" )  ).getImage().getScaledInstance( 16, 16, Image.SCALE_SMOOTH ) ));
		this.salvar = new JButton("Salvar");
		this.fechar = new JButton("Fechar");
		
		this.pnButtons = new JPanel( new FlowLayout() );
		this.pnButtons.add(salvar);
		this.pnButtons.add(fechar);
		
		this.jFileChooserXML = new JFileChooser();
		this.jFileChooserPastas = new JFileChooser();
		this.jFileChooserLogo = new JFileChooser();
		
		this.jFileChooserXML.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.jFileChooserXML.setFileFilter(new XMLFileFilter());
		
		this.jFileChooserLogo.setFileSelectionMode( JFileChooser.FILES_ONLY );
		this.jFileChooserLogo.setFileFilter(new GifFileFilter());
		
		this.jFileChooserPastas.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		this.lupaXML.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
			
	    	jFileChooserXML.showOpenDialog(IntegrationUI.this);
	    	
		    	if(jFileChooserXML.getSelectedFile() != null)
		    	{
		    		setTfCaminhoXML(jFileChooserXML.getSelectedFile().getAbsolutePath());
		    		Config.load(jFileChooserXML.getSelectedFile().getAbsolutePath());
		    		loadProperties();
		    	}
		    }
		} );
		
		this.lupaDanfes.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
			
		    	jFileChooserPastas.showOpenDialog(IntegrationUI.this);
	    	
		    	if(jFileChooserPastas.getSelectedFile() != null)
		    	{
		    		setTfPastaDanfe(jFileChooserPastas.getSelectedFile().getAbsolutePath());
		    	}
		    }
		} );
		
		this.lupaDanfesFSDA.addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				jFileChooserPastas.showOpenDialog(IntegrationUI.this);
				
				if(jFileChooserPastas.getSelectedFile() != null)
				{
					setTfPastaDanfeFSDA(jFileChooserPastas.getSelectedFile().getAbsolutePath());
				}
			}
		} );
		
		this.lupaLogoDanfe.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
			
		    	jFileChooserLogo.showOpenDialog(IntegrationUI.this);
	    	
		    	if(jFileChooserLogo.getSelectedFile() != null)
		    	{
		    		setTfLogoDanfe(jFileChooserLogo.getSelectedFile().getAbsolutePath());
		    	}
		    }
		} );
		
		this.lupaXMLCompactados.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
			
		    	jFileChooserPastas.showOpenDialog(IntegrationUI.this);
	    	
		    	if(jFileChooserPastas.getSelectedFile() != null)
		    	{
		    		setTfXmlCompactado(jFileChooserPastas.getSelectedFile().getAbsolutePath());
		    	}
		    }
		} );
		this.lupaXMLCompactadosFSDA.addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				jFileChooserPastas.showOpenDialog(IntegrationUI.this);
				
				if(jFileChooserPastas.getSelectedFile() != null)
				{
					setTfXmlCompactadoFSDA(jFileChooserPastas.getSelectedFile().getAbsolutePath());
				}
			}
		} );
		
		this.lupaXMLProcessados.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
			
		    	jFileChooserPastas.showOpenDialog(IntegrationUI.this);
	    	
		    	if(jFileChooserPastas.getSelectedFile() != null)
		    	{
		    		setTfXmlProcessado(jFileChooserPastas.getSelectedFile().getAbsolutePath());
		    	}
		    }
		} );
		this.lupaXMLProcessadosFSDA.addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				jFileChooserPastas.showOpenDialog(IntegrationUI.this);
				
				if(jFileChooserPastas.getSelectedFile() != null)
				{
					setTfXmlProcessadoFSDA(jFileChooserPastas.getSelectedFile().getAbsolutePath());
				}
			}
		} );
		
		this.fechar.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
		    	IntegrationUI.super.dispose();
		    }
	    	
		} );
		
		this.salvar.addActionListener( new ActionListener() {
	
		    public void actionPerformed( ActionEvent e ) {
		    	saveProperties();
		    }
	    	
		} );
		
		this.lbThreadSleep.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbCaminhoXML.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbOrientacaoDanfe.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbPortaRMI.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbPastaDanfe.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbPastaDanfeFSDA.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbNroPaginas.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbNroPaginasFSDA.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbImpressora.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbImpressoraFSDA.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbLogoDanfe.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbXmlCompactado.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbXmlCompactadoFSDA.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbXmlProcessado.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbXmlProcessadoFSDA.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		this.lbRazaoSocial.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
	
		this.tfThreadSleep = new JTextField();
	    this.tfCaminhoXML = new JTextField();
	    this.tfPastaDanfe = new JTextField();
	    this.tfPastaDanfeFSDA = new JTextField();
	    this.tfPortaRMI = new JTextField();
	    this.tfNroPaginas = new JTextField();
	    this.tfNroPaginasFSDA = new JTextField();
	    this.tfImpressora = new JTextField();
	    this.tfImpressoraFSDA = new JTextField();
	    this.tfLogoDanfe = new JTextField();
	    this.tfXmlCompactado = new JTextField();
	    this.tfXmlCompactadoFSDA = new JTextField();
	    this.tfXmlProcessado = new JTextField();
	    this.tfXmlProcessadoFSDA = new JTextField();
	    this.tfRazaoSocial = new JTextField();
	    
	    this.pn.add(this.pnButtons, BorderLayout.SOUTH);
	
	    this.pnConnection.add( this.lbCaminhoXML, cellConstraints.xy( 2, 2 ) );
	    this.pnConnection.add( this.lupaXML ,cellConstraints.xy(5, 2) );
		this.pnConnection.add( this.lbThreadSleep, cellConstraints.xy( 2, 3 ) );
		this.pnConnection.add( this.lbOrientacaoDanfe, cellConstraints.xy(2, 4) );
		this.pnConnection.add( this.lbPortaRMI, cellConstraints.xy( 2, 5 ) );
		this.pnConnection.add( this.lbPastaDanfe, cellConstraints.xy( 2, 6 ) );
		this.pnConnection.add( this.lupaDanfes,cellConstraints.xy( 5, 6 ) );
		this.pnConnection.add( this.lbNroPaginas, cellConstraints.xy( 2, 7 ) );
		this.pnConnection.add( this.lbImpressora, cellConstraints.xy( 2, 8 ) );
		this.pnConnection.add( this.lbLogoDanfe, cellConstraints.xy( 2, 9 ) );
		this.pnConnection.add( this.lupaLogoDanfe,cellConstraints.xy( 5, 9 ) );
		this.pnConnection.add( this.lbXmlCompactado,cellConstraints.xy( 2, 10 ) );
		this.pnConnection.add( this.lupaXMLCompactados,cellConstraints.xy( 5, 10 ));
		this.pnConnection.add( this.lbXmlProcessado,cellConstraints.xy( 2, 11 ) );
		this.pnConnection.add( this.lupaXMLProcessados,cellConstraints.xy( 5, 11) );
		this.pnConnection.add( this.lbRazaoSocial,cellConstraints.xy( 2, 12) );
	
		this.pnConnection.add( this.tfCaminhoXML, cellConstraints.xyw( 3, 2, 2 ) );	
		this.pnConnection.add( this.tfThreadSleep, cellConstraints.xyw( 3, 3, 2 ) );
		this.pnConnection.add( this.rbRetrato,cellConstraints.xyw(3, 4, 1) );
		this.pnConnection.add( this.rbPaisagem,cellConstraints.xyw(4, 4, 1) );
		this.pnConnection.add( this.tfPortaRMI, cellConstraints.xyw( 3, 5, 2 ) );
		this.pnConnection.add( this.tfPastaDanfe, cellConstraints.xyw( 3, 6, 2 ) );
		this.pnConnection.add( this.tfNroPaginas, cellConstraints.xyw( 3, 7, 2 ) );
		this.pnConnection.add( this.tfImpressora, cellConstraints.xyw( 3, 8, 2 ) );
		this.pnConnection.add( this.tfLogoDanfe, cellConstraints.xyw( 3, 9 , 2) );
		this.pnConnection.add( this.tfXmlCompactado,cellConstraints.xyw( 3, 10, 2) );
		this.pnConnection.add( this.tfXmlProcessado,cellConstraints.xyw( 3, 11, 2) );
		this.pnConnection.add( this.tfRazaoSocial,cellConstraints.xyw( 3, 12, 2) );
		
		this.pnFSDA.add( this.lbPastaDanfeFSDA, cellConstraints.xy( 2, 2 ) );
		this.pnFSDA.add( this.lbNroPaginasFSDA, cellConstraints.xy( 2, 3 ) );
		this.pnFSDA.add( this.lbImpressoraFSDA, cellConstraints.xy( 2, 4 ) );
		this.pnFSDA.add( this.lbXmlCompactadoFSDA,cellConstraints.xy( 2, 5 ) );
		this.pnFSDA.add( this.lbXmlProcessadoFSDA,cellConstraints.xy( 2, 6 ) );
		
		this.pnFSDA.add( this.tfPastaDanfeFSDA, cellConstraints.xyw( 3, 2, 2 ) );
		this.pnFSDA.add( this.tfNroPaginasFSDA, cellConstraints.xyw( 3, 3, 2 ) );
		this.pnFSDA.add( this.tfImpressoraFSDA, cellConstraints.xyw( 3, 4, 2 ) );
		this.pnFSDA.add( this.tfXmlCompactadoFSDA,cellConstraints.xyw( 3, 5, 2) );
		this.pnFSDA.add( this.tfXmlProcessadoFSDA,cellConstraints.xyw( 3, 6, 2) );
		
		this.pnFSDA.add( this.lupaDanfesFSDA,cellConstraints.xy( 5, 2 ) );
		this.pnFSDA.add( this.lupaXMLCompactadosFSDA,cellConstraints.xy( 5, 5 ));
		this.pnFSDA.add( this.lupaXMLProcessadosFSDA,cellConstraints.xy( 5, 6) );
		
		this.pnTabs.add( this.pn );
		this.pnTabs.add( this.pnFSDA );
    }

    public String getTfThreadSleep() {
		return tfThreadSleep.getText();
	}

	public void setTfThreadSleep(String tfThreadSleep) {
		this.tfThreadSleep.setText(tfThreadSleep);
	}

	public String getTfCaminhoXML() {
		return tfCaminhoXML.getText();
	}

	public void setTfCaminhoXML(String tfCaminhoXML) {
		this.tfCaminhoXML.setText(tfCaminhoXML);
	}

	public String getTfPortaRMI(){
		return this.tfPortaRMI.getText();
	}
	
	public void setTfPortaRMI(String portaRMI)
	{
		this.tfPortaRMI.setText(portaRMI);
	}
	
	public String getTfPastaDanfe()
	{
		return this.tfPastaDanfe.getText();
	}
	
	public void setTfPastaDanfe(String tfPastaDanfe)
	{
		this.tfPastaDanfe.setText(tfPastaDanfe);
	}
	
	public String getTfPastaDanfeFSDA()
	{
		return this.tfPastaDanfeFSDA.getText();
	}
	
	public void setTfPastaDanfeFSDA(String tfPastaDanfe)
	{
		this.tfPastaDanfeFSDA.setText(tfPastaDanfe);
	}
	
	public String getTfNroPaginas()
	{
		return this.tfNroPaginas.getText();
	}
	
	public void setTfNroPaginas(String nroPaginas)
	{
		this.tfNroPaginas.setText(nroPaginas);
	}
	
	public String getTfNroPaginasFSDA()
	{
		return this.tfNroPaginasFSDA.getText();
	}
	
	public void setTfNroPaginasFSDA(String nroPaginas)
	{
		this.tfNroPaginasFSDA.setText(nroPaginas);
	}
	
	public String getTfImpressora()
	{
		return this.tfImpressora.getText();
	}
	
	public void setTfImpressora(String tfImpressora)
	{
		this.tfImpressora.setText(tfImpressora);
	}
	public String getTfImpressoraFSDA()
	{
		return this.tfImpressoraFSDA.getText();
	}
	
	public void setTfImpressoraFSDA(String tfImpressora)
	{
		this.tfImpressoraFSDA.setText(tfImpressora);
	}
	
	public String getTfLogoDanfe()
	{
		return this.tfLogoDanfe.getText();
	}
	
	public void setTfLogoDanfe(String tfLogoDanfe)
	{
		this.tfLogoDanfe.setText(tfLogoDanfe);
	}
	
	public String getTfXmlCompactado()
	{
		return this.tfXmlCompactado.getText();
	}
	
	public void setTfXmlCompactado(String xmlCompactado)
	{
		this.tfXmlCompactado.setText(xmlCompactado);
	}
	public String getTfXmlCompactadoFSDA()
	{
		return this.tfXmlCompactadoFSDA.getText();
	}
	
	public void setTfXmlCompactadoFSDA(String xmlCompactado)
	{
		this.tfXmlCompactadoFSDA.setText(xmlCompactado);
	}
	
	public String getTfXmlProcessado()
	{
		return this.tfXmlProcessado.getText();
	}
	
	public void setTfXmlProcessado(String xmlProcessado)
	{
		this.tfXmlProcessado.setText(xmlProcessado);
	}
	public String getTfXmlProcessadoFSDA()
	{
		return this.tfXmlProcessadoFSDA.getText();
	}
	
	public void setTfXmlProcessadoFSDA(String xmlProcessado)
	{
		this.tfXmlProcessadoFSDA.setText(xmlProcessado);
	}
	
	public String getTfRazaoSocial()
	{
		return this.tfRazaoSocial.getText();
	}
	public void setTfRazaoSocial(String razaoSocial)
	{
		this.tfRazaoSocial.setText(razaoSocial);
	}
	public void loadProperties() {
		this.setTfThreadSleep( Config.getInstance().getEnviNFeThreadSleep() );
		this.setTfPortaRMI( Config.getInstance().configVO.getPortaRMI() );
		this.setTfCaminhoXML( Config.getInstance().getConfigFilePath() );
		this.setTfPastaDanfe( Config.getInstance().configVO.getDanfe() );
		this.setTfNroPaginas( Config.getInstance().configVO.getNroPaginas() );
		this.setTfImpressora( Config.getInstance().configVO.getImpressora() );
		this.setTfLogoDanfe( Config.getInstance().configVO.getLogoDanfe() );
		this.setTfXmlCompactado( Config.getInstance().configVO.getXmlCompactado() );
		this.setTfXmlProcessado( Config.getInstance().configVO.getEnviNFeXMLProcessados() );
		this.setTfRazaoSocial( Config.getInstance().configVO.getRazaoSocial() );
		this.setTfPastaDanfeFSDA(Config.getInstance().configVO.getDanfeFSDA() );
		this.setTfNroPaginasFSDA( Config.getInstance().configVO.getNroPaginasFSDA() );
		this.setTfImpressoraFSDA( Config.getInstance().configVO.getImpressoraFSDA() );
		this.setTfXmlCompactadoFSDA( Config.getInstance().configVO.getXmlCompactadoFSDA() );
		this.setTfXmlProcessadoFSDA( Config.getInstance().configVO.getEnviNFeXMLProcessadosFSDA() );
		this.selecionRadioButton();
    }

    public Boolean saveProperties() 
    {
		try 
		{
			Config.getInstance().setEnviNFeThreadSleep( this.getTfThreadSleep() );
			Config.getInstance().configVO.setPortaRMI(this.getTfPortaRMI());
			Config.getInstance().configVO.setDanfe(this.getTfPastaDanfe());
			Config.getInstance().configVO.setNroPaginas(this.getTfNroPaginas());
			Config.getInstance().configVO.setImpressora(this.getTfImpressora());
			Config.getInstance().configVO.setLogoDanfe(this.getTfLogoDanfe());
			Config.getInstance().configVO.setXmlCompactado(this.getTfXmlCompactado());
			Config.getInstance().configVO.setEnviNFeXMLProcessados(this.getTfXmlProcessado());
			Config.getInstance().configVO.setRazaoSocial(this.getTfRazaoSocial());
			Config.getInstance().configVO.setDanfeFSDA(this.getTfPastaDanfeFSDA());
			Config.getInstance().configVO.setNroPaginasFSDA(this.getTfNroPaginasFSDA());
			Config.getInstance().configVO.setImpressoraFSDA(this.getTfImpressoraFSDA());
			Config.getInstance().configVO.setXmlCompactadoFSDA(this.getTfXmlCompactadoFSDA());
			Config.getInstance().configVO.setEnviNFeXMLProcessadosFSDA(this.getTfXmlProcessadoFSDA());
			Config.getInstance().save();
		} 
		catch ( Exception e ) 
		{
		    logger.error( e );
		    return Boolean.FALSE;
		}
		return Boolean.TRUE;
    }
    private void selecionRadioButton()
    {
    	if(Config.getInstance().configVO.getOrientacaoDanfe().equalsIgnoreCase("R"))
    	{
    		this.rbRetrato.setSelected(true);
    		this.rbPaisagem.setSelected(false);
    	}
    	else
    	{
    		this.rbRetrato.setSelected(false);
    		this.rbPaisagem.setSelected(true);
    	}
    }
    private class RadioButtonActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == IntegrationUI.this.rbRetrato)
			{
				Config.getInstance().configVO.setOrientacaoDanfe("R");
			}
			else
			{
				Config.getInstance().configVO.setOrientacaoDanfe("P");
			}
			Config.getInstance().save();
		}
    }
}