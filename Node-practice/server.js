const express = require('express');
const hbs = require('hbs');
const fs = require('fs');

const port = process.env.PORT || 3000;

var app = express();

hbs.registerPartials(__dirname+'/views/partials')
app.set('view engine', 'hbs');


// APP.USE to register middleware

app.use((req, res, next) => {
  var now = new Date().toString();
  var log = `${now} : ${req.method}  ${req.url}`;
  fs.appendFile('server.log', log + '\n', (err) => {
    if(err){
      console.log('Unable to append to log');
    }
  });
  next();
});

// app.use((req, res, next) => {
//   res.render('maintenance.hbs' , {
//     pageTitle : 'Maintenance page'
//   });
// });

app.use(express.static(__dirname+'/public'));

hbs.registerHelper('getCurrentYear' , () => {
  return new Date().getFullYear();
});

hbs.registerHelper('screamIt', (text) =>{
  return text.toUpperCase();
});
app.get('/' , (req, res) => {
//  res.send('<h1>Hello Express!</h1>');

  // res.send({
  //   name: 'Tarun',
  //   likes: [
  //     'Biking',
  //     'Cities'
  //   ]
  // });

  res.render('home.hbs' , {
    pageTitle : 'About Page',
    welcomeMessage: 'Welcome to Express JS learning'
  });

});

app.get('/about', (req, res) => {
  //res.send('About Page');
  res.render('about.hbs' , {
    pageTitle : 'About Page'
  });
});

app.listen(port, ()=> {
  console.log(`Server is up on port ${port}!`);
});
