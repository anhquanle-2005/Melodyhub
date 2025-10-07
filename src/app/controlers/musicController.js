const music = require('../models/music');
class musicController{
   async index(req, res) {
        try {
            const getmusic = await music.getmusic(); // lấy 3 bài random
            res.json({getmusic});
        } catch (err) {
            console.error(err);
            res.status(500).json({ error: 'Lỗi server' });
        }
    }
    async PlayList(req, res){
        try {
            const data = await music.getPlayList();
            res.json(data);
        } catch (err) {
            console.error(err);
            res.status(500).json({error: 'Lỗi server'});
        }
    }
}
module.exports=new musicController();