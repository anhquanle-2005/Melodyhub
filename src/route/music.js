const express = require('express');
const Router = express.Router();
const musicController = require('../app/controlers/musicController');
Router.get('/3',musicController.index);
Router.get('/playlist',musicController.PlayList);
module.exports = Router;
