# Hotelizate

Hotelizate is a project that includes an API Rest of a hotels data base (with fake data) and an Android mobile application.
This is made up of the API module and android application module

You will need.

  - Install [npm repository]
  - Install [node.js]
  - Install faker and json-server modules via npm
  - Install [Android Studio 3.0.0] or major
  
### Setup API Rest

Before run the Android app, you can run te ``generate_fakerDB.js`` script
```sh
$ node -e 'require("./generate_fakerDB").init()' > db.json
```
Now you need run json-server to generate whole API REST for the db.json collection.

```sh
$ json-server --watch db.json
```
...and that's it! You have the whole API REST for database collection.


### Android application

With your server runing via json-server, you must verify the local IP and port number to the server, and make sure your android device and your server are in the same network.

Before compile the android project you need to change the ```BASE_URL``` value in ```ApiClient.kt``` file, like this:

```java
class ApiClient {

  companion object create {

    private val BASE_URL: String = <Your server URL> // "http://192.168.0.6:3000/"
    private var retrofit: Retrofit? = null

    ...
        
}
```

## License

MIT: http://rem.mit-license.org

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>
   [npm repository]: <https://www.npmjs.com/get-npm>
   [Android Studio 3.0.0]: <https://developer.android.com/studio/install.html>
   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
