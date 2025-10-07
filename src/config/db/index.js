const sql = require('mssql');
const config = {
    user: 'sa',
    password: '12345',
    database: 'MELODYHUB',
    server: 'DESKTOP-OAMTM76',  
    options: {
        // instanceName: 'SQL2022',     
        encrypt: false,              
        trustServerCertificate: true 
    }
};

async function connectDB() {
    try {
        let pool = await sql.connect(config);
        console.log('Kết nối SQL Server thành công');
        return pool;
    } catch (err) {
        console.error('Lỗi kết nối',err);
    }
}
module.exports = {sql,connectDB};