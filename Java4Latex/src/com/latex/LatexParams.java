package com.latex;

public final class LatexParams {
	
	public static String EMPTY = "";
	public static String SPLIT_STR = "*";
	
	public static String LINE_SEPARATOR = System.getProperty("line.separator");
	public static String NEW_LINE = "\\";
	public static String DOUBLE_NEW_LINE = "\\\\ ";
	private static String header = "Unirubber Sp. z o.o.\\\\" + LINE_SEPARATOR + "Zielonka 17, 59-940 Wêgliniec " + LINE_SEPARATOR;
	static String orientation = "";
	static String name="name";
	static String surname="name";
	private static String PROPERTIES  = "\\documentclass[" + orientation + ", 12pt]{article}" + LINE_SEPARATOR;
	private static String SIZE =  "\\usepackage[top=2cm, bottom=2cm, left=2cm, right=2cm]{geometry}" + LINE_SEPARATOR;
	
	private static String BEGIN =  "\\begin{document}" + LINE_SEPARATOR;
	private static String HEADER_FOOTER = "\\pagestyle{fancy}" + LINE_SEPARATOR +
            "\\fancyhf{}" + LINE_SEPARATOR +
            "\\lhead{" + header + "}" + LINE_SEPARATOR +
            "\\rhead{\\includegraphics[scale=0.09]{logo}}" + LINE_SEPARATOR +
            "\\lfoot{" + name + " " + surname + "}" + LINE_SEPARATOR +
            "\\rfoot{\\today}" + LINE_SEPARATOR +
            "\\cfoot{Strona \\thepage}" + LINE_SEPARATOR;
	
	private static String END = "\\end{document}";
	private static String NEW_PAGE = "\\newpage" + LINE_SEPARATOR + "\\thispagestyle{fancy}";
	
}
