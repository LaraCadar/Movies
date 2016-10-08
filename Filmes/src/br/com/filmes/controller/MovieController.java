package br.com.filmes.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieController() {
	
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	request.getRequestDispather(“listaFilme.jsp”);
	request.getRequestDispather(“listaFilme.jsp”).forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Nome do Filme: " + request.getParameter("movieName") );
		response.getWriter().println("Diretor: " + request.getParameter("movieDirector"));
		response.getWriter().println("Ano de Lançamento: " + request.getParameter("movieDate"));
		response.getWriter().println("Gênero: " + request.getParameter("movieGenre"));
		response.getWriter().println("Duração: " + request.getParameter("movieDuration"));
		response.getWriter().println("Sinopse: " + request.getParameter("movieSinopse"));
		
		String nome, diretor, data, genero, duracao, sinopse;
		nome = request.getParameter("movieName");
		diretor=request.getParameter("movieDirector");
		data=request.getParameter("movieDate");
		genero=request.getParameter("movieGenre");
		duracao=request.getParameter("movieDuration");
		sinopse=request.getParameter("movieSinopse");
		
		salvarArquivo(nome, diretor, data, genero, duracao, sinopse);
	}
	
	protected void salvarArquivo (String nome, String diretor, String data, String genero, String duracao, String sinopse) {
		

		FileWriter arq = new FileWriter(("C:/Users/Aluno.LAB01-01/workspace/Filmes/Filmes.txt"),true);
		BufferedWriter write = new BufferedWriter(arq);		
		
		write.write(" --- Filme ---");
		write.newLine();
		write.write("Nome do Filme: " + nome);
		write.newLine();
		write.write("Diretor: " + diretor);
		write.newLine();
		write.write("Ano de Lançamento: " + data);
		write.newLine();
		write.write("Gênero: " + genero);
		write.newLine();
		write.write("Duração: " + duracao);
		write.newLine();
		write.write("Sinopse: " + sinopse);
		write.newLine();
		write.newLine();
		write.close();	
	}
	
	
	
	
