# clipboard

A Clojure library for easy interop with the system clipboard.

## Installation

```
[org.exupero/clipboard "0.1.0"]
```

## Usage

```
(require '[clipboard.core :as clipboard])

(clipboard/slurp)

(clipboard/spit "Hello, World")

(clipboard/spit-html "<strong>Hello</strong>, <em>World</em>")

(clipboard/with-clipboard (println "Hello There!"))
```

## License

Copyright © 2017 Eric Shull

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
