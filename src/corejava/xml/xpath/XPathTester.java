/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.xml.xpath.XPathTester
 * @description:TODO
 * @date:2016-4-14 下午3:07:49
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-14     WangHao       v1.0.0        create
 *
 *
 */
package corejava.xml.xpath;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @className:corejava.xml.xpath.XPathTester
 * @description:This program evaluates XPath expressions
 * @version:v1.0.0
 * @date:2016-4-14 下午3:07:54
 * @author:WangHao
 */
public class XPathTester
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new XPathFrame();
				frame.setTitle("XPathTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * This frame shows an XML document, a panel to type an XPath expression, and a
 * text field to display the result.
 */
class XPathFrame extends JFrame
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private DocumentBuilder builder;
	private Document doc;
	private XPath path;
	private JTextField expression;
	private JTextField result;
	private JTextArea docText;
	private JComboBox<String> typeCombo;

	public XPathFrame()
	{
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				openFile();
			}
		});
		fileMenu.add(openItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		ActionListener listener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				evaluate();
			}
		};

		expression = new JTextField(20);
		expression.addActionListener(listener);
		JButton evaluateButton = new JButton("Evaluate");
		evaluateButton.addActionListener(listener);

		typeCombo = new JComboBox<String>(new String[]
		{ "STRING", "NODE", "NODESET", "NUMBER", "BOOLEAN" });
		typeCombo.setSelectedItem("STRING");

		JPanel panel = new JPanel();
		panel.add(expression);
		panel.add(typeCombo);
		panel.add(evaluateButton);
		docText = new JTextArea(10, 40);
		result = new JTextField();
		result.setBorder(new TitledBorder("Result"));

		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(docText), BorderLayout.CENTER);
		add(result, BorderLayout.SOUTH);

		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		}
		catch (ParserConfigurationException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}

		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
		pack();
	}

	/**
	 * Open a file and load the document
	 */
	public void openFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("xpath"));

		chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
		{

			@Override
			public boolean accept(File f)
			{
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
			}

			@Override
			public String getDescription()
			{
				return "XML file";
			}
		});

		int r = chooser.showOpenDialog(this);
		if (r != JFileChooser.APPROVE_OPTION)
			return;
		File file = chooser.getSelectedFile();
		try
		{
			docText.setText(new String(Files.readAllBytes(file.toPath())));
			doc = builder.parse(file);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		catch (SAXException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}

	public void evaluate()
	{
		try
		{
			String typeName = (String) typeCombo.getSelectedItem();
			QName returnType = (QName) XPathConstants.class.getField(typeName).get(null);
			Object evalResult = path.evaluate(expression.getText(), doc, returnType);
			if (typeName.equals("NODESET"))
			{
				NodeList list = (NodeList) evalResult;
				StringBuilder builder = new StringBuilder();
				builder.append("{");
				for (int i = 0; i < list.getLength(); i++)
				{
					if (i > 0)
						builder.append(", ");
					builder.append("" + list.item(i));
				}
				builder.append("}");
				result.setText("" + builder);
			}
			else
				result.setText("" + evalResult);
		}
		catch (XPathExpressionException e)
		{
			result.setText("" + e);
		}
		catch (Exception e)
		{
			// reflection exception
			e.printStackTrace();
		}
	}
}
