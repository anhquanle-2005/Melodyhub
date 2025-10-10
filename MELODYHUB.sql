IF EXISTS (SELECT * FROM sys.databases WHERE name = N'MELODYHUB')
BEGIN
    -- Đóng tất cả các kết nối đến cơ sở dữ liệu
    EXECUTE sp_MSforeachdb 'IF ''?'' = ''MELODYHUB'' 
    BEGIN 
        DECLARE @sql AS NVARCHAR(MAX) = ''USE [?]; ALTER DATABASE [?] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;''
        EXEC (@sql)
    END'
    -- Xóa tất cả các kết nối tới cơ sở dữ liệu (thực hiện qua hệ thống master)
    USE master;

    -- Xóa cơ sở dữ liệu nếu tồn tại
    DROP DATABASE MELODYHUB;
END
CREATE DATABASE MELODYHUB;
GO
USE MELODYHUB;
GO
CREATE TABLE TaiKhoan(
	MaTK int identity(1,1) Primary key,
	TenTK Nvarchar(50),
	AVT Nvarchar(255),
	SDT varchar(10) unique,
	Pass varchar(25),
	constraint CK_SDT check (SDT like'0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
				
)
Create table NgheSi (
	MaNgheSi int identity(1,1) Primary key,
	TenNgheSi Nvarchar(50),
	AVT Nvarchar(255)
)


CREATE TABLE Music(
	MaBaiHat int identity(1,1) Primary key,
	TenBaiHat Nvarchar(100),
	Anh Nvarchar(255),
	DuongDan Nvarchar(255),
	MaNgheSi int Foreign key references NgheSi(MaNgheSi)
		on delete cascade
		on update cascade
)
CREATE TABLE ChiTietBaiHat (
    MaBaiHat INT,
    MaNgheSi INT,
    PRIMARY KEY (MaBaiHat, MaNgheSi),
    FOREIGN KEY (MaBaiHat) REFERENCES Music(MaBaiHat) ,
    FOREIGN KEY (MaNgheSi) REFERENCES NgheSi(MaNgheSi) 
);
Create table PlayList(
	MaPlayList int identity(1,1) Primary key,
	TenPlaylist Nvarchar(50),
	Anh Nvarchar(255)
)
create table Radio(
	MaRadio int identity(1,1) Primary key,
	TenRadio Nvarchar(25),
	Anh1 Nvarchar(225),
	Anh2 Nvarchar(225),
	Anh3 Nvarchar(225)
)

create table ChiTietRadio(
	
	MaNgheSi int not null,
	MaRadio int not null,
	primary key (MaNgheSi,MaRadio),
	foreign key (MaNgheSi) references NgheSi(MaNgheSi),
	foreign key (MaRadio) references Radio (MaRadio)
)
CREATE TABLE ChiTietPlayList (
    MaBaiHat INT NOT NULL,
    MaPlayList INT NOT NULL,

    PRIMARY KEY (MaBaiHat, MaPlayList),

    CONSTRAINT FK_ChiTiet_Music FOREIGN KEY (MaBaiHat)
        REFERENCES Music(MaBaiHat),


    CONSTRAINT FK_ChiTiet_PlayList FOREIGN KEY (MaPlayList)
        REFERENCES PlayList(MaPlayList)
);
GO

CREATE TRIGGER trg_Delete_Music
ON Music
AFTER DELETE
AS
BEGIN
    DELETE FROM ChiTietPlayList
    WHERE MaBaiHat IN (SELECT MaBaiHat FROM deleted);
END
GO

-- Trigger xóa khi xóa nghệ sĩ


-- Trigger xóa khi xóa playlist
CREATE TRIGGER trg_Delete_PlayList
ON PlayList
AFTER DELETE
AS
BEGIN
    DELETE FROM ChiTietPlayList
    WHERE MaPlayList IN (SELECT MaPlayList FROM deleted);
END
GO
USE MELODYHUB;
GO

-- Tài khoản
INSERT INTO TaiKhoan (TenTK, AVT, SDT, Pass)
VALUES 
(N'Nguyễn Hoài Nam', 'nam.png', '0912345678', '123456'),
(N'Lê Minh Anh', 'anh.png', '0987654321', 'abcdef');

-- Nghệ sĩ
INSERT INTO NgheSi (TenNgheSi, AVT)
VALUES 
(N'Sơn Tùng M-TP', 'https://i.scdn.co/image/ab676161000051745a79a6ca8c60e4ec1440be53'),--1
(N'HIEUTHUHAI', 'https://i.scdn.co/image/ab6761610000517421942907035a43a2d118c55c'),--2
(N'TLinh', 'https://i.scdn.co/image/ab67616100005174230e62752ca87da1d85d0445'),--3
(N'BigDaddy', 'https://i.scdn.co/image/ab67616100005174d11431a2d0efb06cf912d920'),--4
(N'LowG', 'https://i.scdn.co/image/ab676161000051743c9ba0f4c43ffd0c96fef8e4'),--5
(N'Obito', 'https://i.scdn.co/image/ab67616100005174a385bd3e0f67945f277792c2'),--6
(N'DANGRANGTO', 'https://i.scdn.co/image/ab676161000051745b09f4c3eeb52b57f76dccbc'),--7
(N'7DNight', 'https://i.scdn.co/image/ab676161000051746472f3cf3546fcd074f74c14'),--8
(N'Saabirose', 'https://i.scdn.co/image/ab6761610000517499e4695bd75c7dcb2869adc5'),--9
(N'Bray', 'https://i.scdn.co/image/ab6761610000517469b0142434aee6cd70a581bc'),--10
(N'Karik', 'https://i.scdn.co/image/ab676161000051742ef6756afdf74f9b7e3a1861'),--11
(N'Shiki', 'https://i.scdn.co/image/ab6761610000517471581ba96c0dfa03f23beeb9');--12


-- Nhạc
INSERT INTO Music (TenBaiHat,Anh, DuongDan)
VALUES 
(N'Nơi này có anh', 'https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520','https://drive.google.com/uc?export=download&id=1j9SPJXw5OM9HEXJItxi1JHtT_D98G7Y1'),--1  
(N'BigTeam all stars','https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg' ,'https://drive.google.com/uc?export=download&id=130Eah8_U7R0R4Swjr6bxgXUr4KwLfELF'),--2
(N'EZ','https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2' ,'https://drive.google.com/uc?export=download&id=1GAkU_YOteh9HC2hAVPsATe2SnhFDLrA3'),  --3
(N'Love Game','https://i.scdn.co/image/ab67616d00001e02408de2819925aaed9f799a9f' ,'https://drive.google.com/uc?export=download&id=1FIYfSp77cDKb4GTvTZKccBkAkxJNq0Fd'),--4
(N'Hãy Trao Cho Anh', 'https://i.scdn.co/image/ab67616d00001e023403b37254ffacb7732e92da', 'https://drive.google.com/uc?export=download&id=1Km0fW-tsfQXu0KSNLid8Upog-kgWR93L'),--5
(N'Exit Sign', 'https://i.scdn.co/image/ab67616d00001e02c006b0181a3846c1c63e178f', 'https://drive.google.com/uc?export=download&id=16oElKgD-gnLgDYt6SMnPVeqnyedRGjCj'),--6
(N'Ngủ Một Mình', 'https://i.scdn.co/image/ab67616d00001e02321440e7b75c6f210a72c76c', 'https://drive.google.com/uc?export=download&id=1l45sR3pPXhNkF4HMhAG7jWK6q3E3xaNO'),--7
(N'Gái Độc Thân', 'https://i.scdn.co/image/ab67616d00001e0245e5b79c70c345988baad794', 'https://drive.google.com/uc?export=download&id=1SekL3z70z8kKY8uuwf9Tlx1YnzodyjzH'),--8
(N'Mượn Rượu Tỏ Tình', 'https://i.scdn.co/image/ab67616d00001e027b3145efa3de00bc465218b4', 'https://drive.google.com/uc?export=download&id=1R8WKKwjdsFiQxo7hQbqDf8rw8Elcfyc9'),--9
(N'Dáng Xấu', 'https://i.scdn.co/image/ab67616d00001e02c6c6f5debc36cb73bdf0f97d', 'https://drive.google.com/uc?export=download&id=1ndG9uPhJSrw2HyCtctZA7IBQDPO7U-cS'),--10
(N'Simple Love', 'https://i.scdn.co/image/ab67616d00001e02a56db00e4464d25c75e7653c', 'https://drive.google.com/uc?export=download&id=1hD46zNkbcTMqxEC0siSKQmTjaTtuJeQs'),--11
(N'Đến Đây Bên Anh', 'https://i.scdn.co/image/ab67616d00001e02c7d258d4ce12b05006b28f64', 'https://drive.google.com/uc?export=download&id=1rqx85yBcGETXdY9vwSSzlzWoirVJy8bU'),--12
(N'Anh iu', 'https://i.scdn.co/image/ab67616d00001e024078f9dd8f109947e240804d', 'https://drive.google.com/uc?export=download&id=1tIOmZsZfGSCPbeVmSHldw2pws9hpJpJV'),--13
(N'Con Trai Cưng', 'https://i.scdn.co/image/ab67616d00001e027138ce0a585df108255c4423', 'https://drive.google.com/uc?export=download&id=15CyQFye-2n_n9BWrGqJTkcFGqJsTmMEG'),--14
(N'Bạn Đời', 'https://i.scdn.co/image/ab67616d00001e02152208ec7eae42eef5f2dbb7', 'https://drive.google.com/uc?export=download&id=1jQIMg5E2ut_NY2wddJdUqQoAJpHElJi5'),--15
(N'1000 Ánh Mắt', 'https://i.scdn.co/image/ab67616d00001e02c353169a2288f403265ee402', 'https://drive.google.com/uc?export=download&id=1sQE_UqW8yDHiWofsE2-V7yXr3A4uW9y3');--16
INSERT INTO ChiTietBaiHat(MaBaiHat,MaNgheSi)
VALUES
(1,1),
(2,4),
(2,8),
(2,7),
(3,9),
(3,8),
(4,5),
(4,3),
(5,1),
(6,2),
(7,2),
(8,3),
(9,4),
(10,5),
(11,6),
(12,7),
(13,9),
(14,10),
(15,11),
(16,12);
-- Playlist
INSERT INTO PlayList (TenPlaylist, Anh)
VALUES
(N'Nhạc trẻ hot', 'nhactre.png'),
(N'Nhạc chill', 'nhacchill.png');

insert into Radio(TenRadio,Anh1,Anh2,Anh3)
values
(N'Obito','https://i.scdn.co/image/ab67616100005174a385bd3e0f67945f277792c2','https://i.scdn.co/image/ab676161000051745a79a6ca8c60e4ec1440be53','https://i.scdn.co/image/ab6761610000517421942907035a43a2d118c55c'),
(N'LowG','https://i.scdn.co/image/ab676161000051743c9ba0f4c43ffd0c96fef8e4','https://i.scdn.co/image/ab67616100005174230e62752ca87da1d85d0445','https://i.scdn.co/image/ab67616100005174a385bd3e0f67945f277792c2'),
(N'Dangrangto','https://i.scdn.co/image/ab676161000051745b09f4c3eeb52b57f76dccbc','https://i.scdn.co/image/ab6761610000517499e4695bd75c7dcb2869adc5','https://i.scdn.co/image/ab6761610000517469b0142434aee6cd70a581bc'),
(N'HIEUTHUHAI','https://i.scdn.co/image/ab6761610000517421942907035a43a2d118c55c','https://i.scdn.co/image/ab676161000051742ef6756afdf74f9b7e3a1861','https://i.scdn.co/image/ab6761610000517471581ba96c0dfa03f23beeb9'),
(N'SaaBirose','https://i.scdn.co/image/ab6761610000517499e4695bd75c7dcb2869adc5','https://i.scdn.co/image/ab676161000051746472f3cf3546fcd074f74c14','https://i.scdn.co/image/ab67616100005174230e62752ca87da1d85d0445'),
(N'Sơn Tùng M-TP','https://i.scdn.co/image/ab676161000051745a79a6ca8c60e4ec1440be53','https://i.scdn.co/image/ab676161000051743c9ba0f4c43ffd0c96fef8e4','https://i.scdn.co/image/ab6761610000517421942907035a43a2d118c55c');
insert into ChiTietRadio( MaNgheSi,MaRadio)
values
(6,1),
(2,1),
(1,1),
(4,1),
(5,2),
(3,2),
(6,2),
(7,2),
(7,3),
(9,3),
(10,3),
(4,3),
(2,4),
(11,4),
(12,4),
(1,4),
(9,5),
(8,5),
(3,5),
(10,5),
(1,6),
(5,6),
(2,6),
(6,6);
SELECT TOP 3 
    M.TenBaiHat,
    M.Anh,
	M.DuongDan,
    STRING_AGG(N.TenNgheSi, ', ') AS TenNgheSi
FROM Music M
JOIN ChiTietBaiHat MN ON M.MaBaiHat = MN.MaBaiHat
JOIN NgheSi N ON MN.MaNgheSi = N.MaNgheSi
GROUP BY M.MaBaiHat, M.TenBaiHat,M.DuongDan, M.Anh
ORDER BY NEWID();  -- chọn ngẫu nhiên 3 bài hát
select * from Music
Select top 5 TenRadio , Anh1, Anh2, Anh3, STRING_AGG(NS.TenNgheSi,', ')AS TenNgheSi
from Radio R, ChiTietRadio CT, NgheSi NS
where R.MaRadio = CT.MaRadio and CT.MaNgheSi=NS.MaNgheSi
Group by TenRadio , Anh1, Anh2, Anh3
select M.TenBaiHat, M.Anh, M.DuongDan, STRING_AGG(N.TenNgheSi, ', ') AS TenNgheSi
FROM Music M
JOIN ChiTietBaiHat MN ON M.MaBaiHat = MN.MaBaiHat
JOIN NgheSi N ON MN.MaNgheSi = N.MaNgheSi
GROUP BY M.MaBaiHat, M.TenBaiHat,M.DuongDan, M.Anh
ORDER BY NEWID();