const express =  require('express');
const DB = require('./config/db/index')
const router = require('./route/index')
const app = express();
DB.connectDB();
router(app);
const port = 3000;
app.listen(port,()=>{
    console.log(`Example app listening on port ${port}`)
})
