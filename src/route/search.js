const express = require('express');
const Router = express.Router();
const searchController = require('..//app/controlers/searchController');
Router.get('/', searchController.find);
module.exports = Router;