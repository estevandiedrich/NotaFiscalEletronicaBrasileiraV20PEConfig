package br.com.hs.nfe.pe.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XMLFileFilter extends FileFilter {

	public boolean accept(File f) {
		return f.isDirectory() || f.getName().endsWith("xml");
	}
	public String getDescription() {
		return "Arquivos XML";
	}

}
