# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

📝 `NOTE - PASTE PART 2 SNIPPET HERE:` Paste the README template for part 2 of this assignment here at the top. This will show a history of your development process, which users stories you completed and how your app looked and functioned at each step.

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [ ] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

Portrait view of the app

<img src="https://media.giphy.com/media/rjifMp6sAkuw25NNzi/giphy.gif"><br>

Landscape view of the app

<img src="https://media.giphy.com/media/agl8x20krVDwSBByx5/giphy.gif"><br>

The transition between portrait and landscape orientation of the app

<img src="https://media.giphy.com/media/91UUbTiEtuHQyxOITz/giphy.gif"><br>

### Notes
Describe any challenges encountered while building the app.

- I had some trouble figuring out how to add teh XML file for the landscape orientation even though I have followed the instructions. After figuring out how to add the landscape view for the app, the UI still does not look like what I expected. However, after adding a separate layout file for the landscape view instead of reusing the layout file of the portrait view, I was able to make the UI look like what I want in both orientations.
- I also encountered some troubles using Glide to add more style to the images. However, after giving it some thoughts, I realized that I can change the styles of the images (i.e add border, add margin, etc) directly in Android Studio without having to use effects from Glide library.
- Finally, since the demo GIFs I recorded was a bit long, I could not figure out how to make the hosted GIF files look better when being included in this README. The website that hosts my GIFs compresses the files, which makes them a little blurry. 

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
