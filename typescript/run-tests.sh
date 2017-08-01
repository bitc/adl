#!/bin/bash

set -e

HERE="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
GENDIR=$HERE/build
HASKELLDIR=$HERE/../haskell
ADLSTDLIBDIR=$(cd $HASKELLDIR; stack exec adlc -- show --adlstdlib)

rm -rf $GENDIR
mkdir -p $GENDIR

# Build ADL and dependencies setup
(cd $HERE/../haskell; stack exec adlc -- typescript -I $ADLSTDLIBDIR -O $GENDIR --include-rt --runtime-dir $GENDIR/runtime $HERE/example.adl $ADLSTDLIBDIR/sys/types.adl $ADLSTDLIBDIR/sys/adlast.adl $ADLSTDLIBDIR/sys/dynamic.adl)
yarn

# Compile everything to check all the types, as running jest-ts doesn't actually do so :-(
cp tsconfig.json $GENDIR
rm -rf $GENDIR/tsc-out
./node_modules/.bin/tsc --outDir $GENDIR/tsc-out -p $GENDIR; rm -rf $GENDIR/tsc-out

# Run tests
yarn test
