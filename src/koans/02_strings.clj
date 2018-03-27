(ns koans.02-strings
  (:require [koan-engine.core :refer :all]
            [clojure.string :as testish]
            [clojure.string :as string]
            ))



(meditations
  "A string is nothing more than text surrounded by double quotes"
  (= "hello" "hello")

  "But double quotes are just magic on top of something deeper"
  (= "world" (str 'world))

  "You can do more than create strings, you can put them together"
  (= "Cool right? DinMamma" (str 'Cool " right?" (str " DinMamma")))

  "You can even get certain characters, Zero index yeah!"
  (= \h (get "Characters" 1))

  "Or even count the characters"
  (= 11 (count "Hello World"))

  "But strings and characters are not the same"
  (= false (= \c "c"))

  "What if you only wanted to get part of a string?"
  (= "World" (subs "Hello World" 6 11))

  "How about joining together elements in a list?"
  (= "123" (testish/join '(1 2 3)))

  "What if you wanted to separate them out?"
  (= "1. 2. 3" (testish/join ". " '(1 2 3)))

  "Maybe you want to separate out all your lines"
  (= ["1" "2" "3"] (testish/split-lines "1\n2\n3"))

  "You may want to make sure your words are backwards"
  (= "olleh" (string/reverse "hello"))

  "Maybe you want to find the index of the first occurrence of a substring"
  (= 0 (string/index-of "hello world" "hello"))

  "Or maybe the last index of the same"
  (= 13 (string/last-index-of "hello world, hello" "hello"))

  "But when something doesn't exist, nothing is found"
  (= nil (string/index-of "hello world" "bob"))

  "Sometimes you don't want whitespace cluttering the front and back"
  (= "hello world" (string/trim "  \nhello world \t \n"))

  "Can you check if shit is func?"
  (= true (fn? (fn []("dont swear in a meditation"))))

  "You can check if something is a char"
  (= true (char? \c))

  "But it may not be"
  (= false (char? "a"))

  "But chars aren't strings"
  (= false (string? \b))

  "Strings are strings"
  (= true (string? (str 'apa)))

  "Some strings may be blank"
  (= true (string/blank? ""))

  "Even if at first glance they aren't"
  (= true (string/blank? " \n \t  "))

  "But they're still not empty is containing only blanks?"
;  (= false (string/empty? " \n \t  ")) ("There is no empty method")
  (= false (= "" " \n \t  "))

  "However, most strings aren't blank"
  (= false (string/blank? "hello?\nare you out there?")))
