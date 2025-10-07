const checkApiKey = require('../config/config')
const musicRouter = require('./music');
const searchRouter= require('./search');
function router(app)
{
    app.use('/music',checkApiKey,musicRouter);
   app.use('/search',checkApiKey,searchRouter);
}
module.exports  = router;
