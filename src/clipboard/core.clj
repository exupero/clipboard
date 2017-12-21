(ns clipboard.core
  (:refer-clojure :exclude [slurp spit])
  (:import [java.awt.datatransfer DataFlavor StringSelection Transferable]))

(defn clipboard []
  (.getSystemClipboard (java.awt.Toolkit/getDefaultToolkit)))

(defn slurp []
  (try
    (.getTransferData (.getContents (clipboard) nil) (DataFlavor/stringFlavor))
    (catch java.lang.NullPointerException e nil)))

(defn spit [text]
  (let [selection (StringSelection. text)]
    (.setContents (clipboard) selection selection)))

(def html-flavors
  (into #{}
        (map #(DataFlavor. %))
        ["text/html;class=java.lang.String"
         "text/html;class=java.io.Reader"
         "text/html;charset=unicode;class=java.io.InputStream"]))

(defrecord HtmlSelection [html]
  Transferable
  (isDataFlavorSupported [_ flavor]
    (contains? html-flavors flavor))
  (getTransferDataFlavors [_]
    (into-array DataFlavor html-flavors))
  (getTransferData [_ flavor]
    (condp = (.getRepresentationClass flavor)
      java.lang.String html
      java.io.Reader (java.io.StringReader. html)
      java.io.InputStream (java.io.StringBufferInputStream html))))

(defn spit-html [html]
  (.setContents (clipboard) (HtmlSelection. html) nil))
