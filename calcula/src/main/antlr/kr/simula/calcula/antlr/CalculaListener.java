// Generated from Calcula.g4 by ANTLR 4.4

	package kr.simula.calcula.antlr;
	
	import java.util.List;
	import java.util.LinkedList;
	
	import kr.simula.calcula.core.*;
	import kr.simula.calcula.core.builder.*;
	import kr.simula.calcula.def.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculaParser}.
 */
public interface CalculaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculaParser#formulaTerm}.
	 * @param ctx the parse tree
	 */
	void enterFormulaTerm(@NotNull CalculaParser.FormulaTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#formulaTerm}.
	 * @param ctx the parse tree
	 */
	void exitFormulaTerm(@NotNull CalculaParser.FormulaTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(@NotNull CalculaParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(@NotNull CalculaParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull CalculaParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull CalculaParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#formulaExpression}.
	 * @param ctx the parse tree
	 */
	void enterFormulaExpression(@NotNull CalculaParser.FormulaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#formulaExpression}.
	 * @param ctx the parse tree
	 */
	void exitFormulaExpression(@NotNull CalculaParser.FormulaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(@NotNull CalculaParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(@NotNull CalculaParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull CalculaParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull CalculaParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull CalculaParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull CalculaParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull CalculaParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull CalculaParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(@NotNull CalculaParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(@NotNull CalculaParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#funcCallExp}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExp(@NotNull CalculaParser.FuncCallExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#funcCallExp}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExp(@NotNull CalculaParser.FuncCallExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(@NotNull CalculaParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(@NotNull CalculaParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(@NotNull CalculaParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(@NotNull CalculaParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#operatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOperatorExpression(@NotNull CalculaParser.OperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#operatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOperatorExpression(@NotNull CalculaParser.OperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#methodCallExp}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExp(@NotNull CalculaParser.MethodCallExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#methodCallExp}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExp(@NotNull CalculaParser.MethodCallExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull CalculaParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull CalculaParser.ArgumentsContext ctx);
}