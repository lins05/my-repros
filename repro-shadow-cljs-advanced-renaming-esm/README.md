### Issue Description

ESM files used in a shadow-cljs project have its property-renamed under advanced optimization.

Ofc this is fix-able by using an externs file. But it's cumbersome to add lots
of externs. Ideally this shall work out of the box without any externs files.

### How To

Install JS deps:

```
yarn install 
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

Relese build fails due to the renaming:

```bash
$ yarn node -e "require('./output/release/app.main.js')"

my-repros/repro-advanced-renaming-js/output/release/app.main.js:46
  $dog$jscomp$inline_477$$.$bark$();
                           ^

TypeError: $dog$jscomp$inline_477$$.$bark$ is not a function
    at Object.<anonymous> (my-repros/repro-advanced-renaming-js/output/release/app.main.js:46:28)
...
```

From the output we can tell that `bark` is renamed to `$bark$`. If we turn off
`:pseudo-names true` it would be renamed to shorter names like `Nb`.
