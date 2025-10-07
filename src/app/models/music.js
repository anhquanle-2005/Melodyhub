const {sql,connectDB}= require('../../config/db/index');
async function getmusic() {
    try {
        let pool = await connectDB();
        let result = await pool.request().query(`SELECT TOP 3 M.TenBaiHat, M.DuongDan, M.Anh, STRING_AGG(N.TenNgheSi, ', ') AS TenNgheSi`+
                                                    ` FROM Music M` +
                                                    ` JOIN ChiTietBaiHat MN ON M.MaBaiHat = MN.MaBaiHat`+
                                                    ` JOIN NgheSi N ON MN.MaNgheSi = N.MaNgheSi`+
                                                    ` GROUP BY M.MaBaiHat, M.TenBaiHat,M.DuongDan , M.Anh`+
                                                    ` ORDER BY NEWID();`);
        return result.recordset;
    } catch (err) {
        console.error('Lỗi query:', err);
    }
}
async function getPlayList() {
    try {
        let pool = await connectDB();
        let result = await pool.request().query('SELECT * from PlayList ');
        return result.recordset;
    } catch (err) {
        console.error('Lỗi query:',err);
    }
}
module.exports ={getmusic,getPlayList}