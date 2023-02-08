### Issue Description

With `:js-provider :import` and `:target :esm`, using a npm ESM pkg
(`prosemirror-state` in this case) from a classpath ESM file resulted in
advanced compilation error.

### How To

Install JS deps:

```
yarn install
```

Build with advanced compilation and you would see the errors:

```
$ yarn build-release

> clj -A:shadow-cljs -M:shadow-cljs "release" "app"

[:app] Compiling ...
Closure compilation failed with 1 errors
--- app/util_esm.js:1
Required namespace "esm_import$prosemirror_state" never defined.

 ELIFECYCLE  Command failed with exit code 1.
```
