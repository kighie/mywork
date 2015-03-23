// Generated from Calcula.g4 by ANTLR 4.4

	package kr.simula.calcula.antlr;
	
	import java.util.List;
	import java.util.LinkedList;
	
	import kr.simula.calcula.core.*;
	import kr.simula.calcula.builder.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculaParser}.
 */
public interface CalculaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculaParser#funcExp}.
	 * @param ctx the parse tree
	 */
	void enterFuncExp(@NotNull CalculaParser.FuncExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#funcExp}.
	 * @param ctx the parse tree
	 */
	void exitFuncExp(@NotNull CalculaParser.FuncExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull CalculaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull CalculaParser.TermContext ctx);
}