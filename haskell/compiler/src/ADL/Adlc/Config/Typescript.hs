{-# LANGUAGE OverloadedStrings #-}
module ADL.Adlc.Config.Typescript(
    TypescriptGenerate,
) where

import ADL.Core
import Control.Applicative( (<$>), (<*>), (<|>) )
import Prelude( ($) )
import qualified Data.Aeson as JS
import qualified Data.HashMap.Strict as HM
import qualified Data.Proxy
import qualified Prelude

type TypescriptGenerate = Prelude.Bool