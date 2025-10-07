const {sql, connectDB} =require('../../config/db/index');
class Search{
    async searchMusic(keyword){
        try {
            let pool = await connectDB();
            let sqlQuery = `
                SELECT
                    M.MaBaiHat, M.TenBaiHat, M.Anh, M.DuongDan,
                    STRING_AGG(N.TenNgheSi, ', ') AS TenNgheSi
                FROM Music M
                JOIN ChiTietBaiHat MN ON M.MaBaiHat = MN.MaBaiHat
                JOIN NgheSi N ON MN.MaNgheSi = N.MaNgheSi
                GROUP BY M.MaBaiHat, M.TenBaiHat, M.DuongDan, M.Anh
            `;
            const request =pool.request();
            if(keyword&& keyword.trim()!==''){
                sqlQuery ='SELECT M.MaBaiHat, M.TenBaiHat, M.Anh, M.DuongDan, STRING_AGG(N.TenNgheSi, \', \') AS TenNgheSi'+
                ' FROM Music M'+
                ' JOIN ChiTietBaiHat MN ON M.MaBaiHat = MN.MaBaiHat'+
                ' JOIN NgheSi N ON MN.MaNgheSi = N.MaNgheSi'+
                ' WHERE M.TenBaiHat LIKE @keyword OR N.TenNgheSi LIKE @keyword'+
                ' GROUP BY M.MaBaiHat, M.TenBaiHat, M.DuongDan, M.Anh';
                request.input('keyword', sql.NVarChar, `%${keyword}%`);

            }
            let result = await request.query(sqlQuery);
            return result.recordset;

        } catch (error) {
            console.error('Error searching music:', error);
            throw error;
        }
    }
}
module.exports = new Search();