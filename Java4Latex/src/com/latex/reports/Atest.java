package com.latex.reports;

import com.latex.LatexParams;

public class Atest {
	
	private static String AMPERSANT = " & ";
	private static String SEMICOLON = ";";

	private String mText = LatexParams.EMPTY;
	
	public Atest(String nr, String name, String[] date, String recipe, String type, String type2, String color, String prop1, String prop2, String data){
		mText = "\\begin{center}\\LARGE Atest " + nr + "\\end{center}" + LatexParams.LINE_SEPARATOR + 
		          "\\begin{normalsize}" + LatexParams.LINE_SEPARATOR + 
		          "\\begin{tabular}{ll}" + LatexParams.LINE_SEPARATOR + 
		          "Nazwa produktu"+AMPERSANT + name + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Nazwa receptury"+AMPERSANT + recipe + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Typ"+ AMPERSANT + type + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Typ materia³u"+AMPERSANT + type2 + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Kolor"+AMPERSANT + color + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "\\end{tabular}" + LatexParams.LINE_SEPARATOR + 
		          LatexParams.DOUBLE_NEW_LINE+ LatexParams.DOUBLE_NEW_LINE +LatexParams.DOUBLE_NEW_LINE +LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "\\begin{tabular}{|p{7cm} p{3cm} p{3cm} p{3cm}|}" + LatexParams.LINE_SEPARATOR + 
		          "\\hline" + LatexParams.LINE_SEPARATOR + 
		          "\\textbf{W³asnoœci}"+AMPERSANT+"\\textbf{Wartoœæ}"+AMPERSANT+"\\textbf{Jednostka}"+AMPERSANT+"\\textbf{Norma} \\\\" + LatexParams.LINE_SEPARATOR + 
		          "\\rowcolor{gray}" + LatexParams.LINE_SEPARATOR + 
		          "W³asnoœci fizyczne i chemiczne:"+AMPERSANT+AMPERSANT+AMPERSANT+ LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "\\rowcolor{white}" + LatexParams.LINE_SEPARATOR + 
		          "Wytrzyma³oœæ na rozci¹ganie" + AMPERSANT + date[0].split(SEMICOLON)[0] + AMPERSANT + date[0].split(SEMICOLON)[1] + AMPERSANT + date[0].split(SEMICOLON)[2] + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Wyd³u¿enie w chwili zerwania" + AMPERSANT + date[1].split(SEMICOLON)[0] + AMPERSANT + date[1].split(SEMICOLON)[1] + AMPERSANT + date[1].split(SEMICOLON)[2] + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Twardoœæ"+AMPERSANT+ date[2].split(SEMICOLON)[0] + AMPERSANT + date[2].split(SEMICOLON)[1] + AMPERSANT + date[2].split(SEMICOLON)[2] + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Œcieralnoœæ"+AMPERSANT+ date[3].split(SEMICOLON)[0] + AMPERSANT + date[3].split(SEMICOLON)[1] + AMPERSANT + date[3].split(SEMICOLON)[2] + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Temperatura wulkanizacji"+AMPERSANT + date[4].split(SEMICOLON)[0] + AMPERSANT + date[4].split(SEMICOLON)[1] + AMPERSANT + date[4].split(SEMICOLON)[2] + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "Czas wulkanizacji"+AMPERSANT + date[5].split(SEMICOLON)[0] + AMPERSANT + date[5].split(SEMICOLON)[1] + AMPERSANT + date[5].split(SEMICOLON)[2] + LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "\\rowcolor{gray}" + LatexParams.LINE_SEPARATOR + 
		          "Pozosta³e w³asnoœci:"+AMPERSANT+AMPERSANT+AMPERSANT+ LatexParams.DOUBLE_NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "\\rowcolor{white}" + LatexParams.LINE_SEPARATOR + 
		          "Czas przechowywania mieszanki" + AMPERSANT + prop1 + "&&\\\\" + LatexParams.LINE_SEPARATOR + 
		          "Opakowanie" + AMPERSANT+ "\\multicolumn{3}{p{9cm}|}{" + prop2 + "}\\\\" + LatexParams.LINE_SEPARATOR + 
		          "\\hline" + LatexParams.LINE_SEPARATOR + "\\end{tabular}" + LatexParams.LINE_SEPARATOR + 
		          "\\\\ \\\\ \\\\ \\\\" + LatexParams.LINE_SEPARATOR + 
		          "Data wystawienia atestu: " + data + LatexParams.LINE_SEPARATOR + 
		          "\\end{normalsize}" + LatexParams.LINE_SEPARATOR + 
		          LatexParams.NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          LatexParams.NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          LatexParams.NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          LatexParams.NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          LatexParams.NEW_LINE + LatexParams.LINE_SEPARATOR + 
		          "\\begin{large}Wszystkie dane techniczne zawarte w tym dokumencie s¹ zgodne z nasz¹ aktualn¹ wiedz¹ "
		          + "o produkcie i przedstawione by pomóc naszym Klientom. Nie stanowi¹ one natomiast gwarancji jakoœci "
		          + "ani nie mog¹ byæ podstaw¹ dla odpowiedzialnoœci prawnej.\\end{large}" + LatexParams.LINE_SEPARATOR;
	}
	
	public String getText(){
		return mText;
	}
}
