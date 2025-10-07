require("dotenv").config();
   const apikey = process.env.API_KEY;
function checkApiKey(req,res,next){
    // const key = req.headers["x-api-key"];
    // if(key && key == apikey)
    // {
        next();
    // }else{
    //     res.status(401).json({error: "APIKey ko hợp lệ"})
    // }
}
module.exports = checkApiKey;