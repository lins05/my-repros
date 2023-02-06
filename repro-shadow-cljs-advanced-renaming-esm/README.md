### Issue Description

ESM files used in a shadow-cljs project have its property-renamed.

Ofc this is fix-able by using an externs file. But that's cumbersome, and ideally
this shall work of the box without any externs files.

### How To

Install JS deps:

```
yarn install 
# or
npm install
# or 
pnpm install
```

Build the release files:

```bash
yarn build-dev
yarn build-release
```


Try to load the compiled code:

Dev build runs fine:
```
$ yarn node -e "require('./output/dev/app.main.js')"

Bark from ESM!
```

Relese build fails due to the renaming

```bash
$ yarn node -e "require('./output/release/app.main.js')"

my-repros/repro-advanced-renaming-js/output/release/app.main.js:46
  $dog$jscomp$inline_477$$.$bark$();
                           ^

TypeError: $dog$jscomp$inline_477$$.$bark$ is not a function
    at Object.<anonymous> (my-repros/repro-advanced-renaming-js/output/release/app.main.js:46:28)
    at Module._compile (node:internal/modules/cjs/loader:1109:14)
    at Object.Module._extensions..js (node:internal/modules/cjs/loader:1138:10)
    at Module.load (node:internal/modules/cjs/loader:989:32)
    at Function.Module._load (node:internal/modules/cjs/loader:829:14)
    at Module.require (node:internal/modules/cjs/loader:1013:19)
    at require (node:internal/modules/cjs/helpers:93:18)
    at [eval]:1:1
    at Script.runInThisContext (node:vm:129:12)
    at Object.runInThisContext (node:vm:306:38)
error Command failed.
```

From the output we can tell that `bark` is renamed to `$bark$`. If we turn off
`:pseudo-names true` it would be renamed to shorter names like `Nb`.
