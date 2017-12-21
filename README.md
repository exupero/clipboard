# clipboard

A Clojure library for easy interop with the system clipboard.

## Usage

```
(require '[clipboard.core :as clipboard])

(clipboard/slurp)

(clipboard/spit "Hello, World")

(clipboard/spit-html "<strong>Hello</strong>, <em>World</em>")
```

## License

Copyright © 2017 Eric Shull

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
