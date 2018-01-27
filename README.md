# Dirac Repro

A minimal project to reproduce an issue with Dirac, where aliases and referred symbols are visible in autocomplete, but returns undefined when referenced.

## Steps to reproduce

- Run `boot dev`
- Run Chrome Canary:
```
/Applications/Google\ Chrome\ Canary.app/Contents/MacOS/Google\ Chrome\ Canary \
  --remote-debugging-port=9222 \
  --no-first-run
```
- Start Dirac Devtools with `cmd-shift-i`
- If not already in the ClojureScript REPL, switch to it with `CTRL+.`
- Execute `(in-ns 'dirac-repro.core)`
- Execute `reagent.core`: returns the correct namespace
- Execute `reagent`: returns undefined, but should also return `reagent.core`
- Execute `(dirac-repro.as-aliased/some-func :foo)`: logs `"some-func -> :foo"`
- Execute `(as-aliased/some-func :foo)`: throws `ReferenceError: as_aliased is not defined`
- Execute `(dirac-repro.with-refer/the-referred-thing :bar)`: logs `"the-referred-thing -> :bar"`
- Execute `(the-referred-thing :bar)`: throws `TypeError: Cannot read property 'call' of undefined`
