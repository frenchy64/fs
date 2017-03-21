#!/bin/sh

echo 'Disabling :lang on me.raynes.fs\n'
perl -pi -e 's/:lang :core.typed/;:lang :core.typed/g' src/me/raynes/fs.clj
lein test :only me.raynes.test-with-specs-fs
perl -pi -e 's/;:lang :core.typed/:lang :core.typed/g' src/me/raynes/fs.clj
