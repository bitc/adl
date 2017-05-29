{-# LANGUAGE FlexibleInstances #-}
{-# LANGUAGE OverloadedStrings #-}
module ADL.Compiler.Backends.Typescript.Newtype where
import           ADL.Compiler.AST
import           ADL.Compiler.Backends.Typescript.Common
import           ADL.Compiler.Backends.Typescript.DataTypes
import           ADL.Utils.IndentedCode


genNewtype :: CModule -> CDecl -> Newtype CResolvedType -> CState ()
genNewtype  m declaration ntype@Newtype{n_typeParams=typeParams} = do
  typeExprOutput <- genTypeExpr (n_typeExpr ntype)
  let
    typeDecl = ctemplate "export type $1$2 = $3;" [d_name declaration, typeParamsExpr typeParams, typeExprOutput]
  addDeclaration typeDecl
  addAstDeclaration m declaration
