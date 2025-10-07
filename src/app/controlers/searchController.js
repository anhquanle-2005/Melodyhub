const searchModel = require('../models/search');
class searchController {
    async find(req, res) {
        try{
            const keyword = req.query.q ||'';
            const results = await searchModel.searchMusic(keyword);
            res.json(results);
        
        }catch 
        (err){
            res.status(500).json({message: 'Lỗi server khi tim nhac '});
        }
    }
}
module.exports = new searchController();
