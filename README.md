create database appReadStories
use appReadStories

CREATE TABLE Truyen (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tenTruyen VARCHAR(255) NOT NULL,
    posterURL VARCHAR(255),
    moTa TEXT
);

CREATE TABLE Chapter (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idTruyen INT,
    tenChapter VARCHAR(255),
    linkChapter TEXT,
    FOREIGN KEY (idTruyen) REFERENCES Truyen(id)
);

INSERT INTO Truyen (tenTruyen, posterURL, moTa) 
VALUES 
('Truyện Kiếm Hiệp', 'https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain', 'Một câu chuyện đầy rẫy các cuộc phiêu lưu kiếm hiệp.'),
('Truyện Ngôn Tình', 'https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain', 'Câu chuyện tình yêu lãng mạn giữa hai nhân vật chính.'),
('Truyện Khoa Học Viễn Tưởng', 'https://th.bing.com/th/id/OIP.2ypBd-zd11jYI88557aIgwHaQD?rs=1&pid=ImgDetMain', 'Khám phá những thế giới ngoài hành tinh và tương lai xa.');



chapterINSERT INTO Chapter (idTruyen, tenChapter, linkChapter) 
VALUES 
(1, 'Kiếm Hiệp - Chương 1', 'https://truyenchufull.org/63037e0b458c02619c6ed8a4'),
(1, 'Kiếm Hiệp - Chương 2', 'https://truyenchufull.org/63037e0b458c02619c6ed8a4'),
(2, 'Ngôn Tình - Chương 1', 'https://truyenchufull.org/63037e0b458c02619c6ed8a4'),
(3, 'Khoa Học Viễn Tưởng - Chương 1', 'https://truyenchufull.org/63037e0b458c02619c6ed8a4'),
(3, 'Khoa Học Viễn Tưởng - Chương 2', 'https://truyenchufull.org/63037e0b458c02619c6ed8a4');
