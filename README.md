# bookreview
website to review books using MVC

BookReview is a website that gives a set of review crawled from multiple other sites.
It uses Java Spring MVC Framework for passing the request to the pages and the controller will perform the necessary actions to get the required results.
Website UI is created using Bootstrap CSS and HTML.

The basic idea of this website is to enable users to click pictures when they are at a shop of the front page of the book and obtain the reviews of the book instantly allowing them to decide the purchase of the book.
This website has set of images already uploaded for the purpose of testing, the user can click on the image and the backend OCR(Optical Character Recognition) Tessaract can convert the image from pixels to text data. 
Upon conversion the obtained text is crawled over the search engine from multiple other sites and the reviews are obtained and displayed on the website.


Future Work:
1. User should be able to upload their image and obtain the results.
2. Sentiment Analysis on the reviews obtained.
3 OCR can be optimised by the use of Neural Network and deep learning concepts.