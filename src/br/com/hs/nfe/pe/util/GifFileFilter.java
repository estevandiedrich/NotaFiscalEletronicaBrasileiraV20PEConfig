package br.com.hs.nfe.pe.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class GifFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		return f.isDirectory() || f.getName().endsWith("gif");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Arquivos Gif";
	}

}
