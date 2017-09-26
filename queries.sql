insert into pdz_podcasters values(
19,
'Nerd2',
'https://www.ivoox.com/perfil-nerd2_aj_155994_1.html',
'Nerd2 live Circus, en vivo todos los miércoles a las 22:00 hrs (ciudad de México). Con @santonerd y @Mr_Buho, Noticias del mundo y de iztapalapa, Política, Estupidez colectiva, Cine, tecnología, recomendaciones y altas dosis de comedia.',
'https://static-2.ivooxcdn.com/usuarios/3/0/1/2/8081474382103_MD.jpg');

insert into pdz_podcasts values(
19,
19,
'images\\el-pasquin.jpg',
'http://elpasquin.com',
'El único programa de análisis político, sin analistas políticos.',
'http://feeds.feedburner.com/ElPasquinmx',
'a3',
'2017-08-10 00:00:00',
'el-pasquin.xml',
'ITunes',
'@pasquinmx',
'@pasquinmx',
'El Pasquín'
);

update pdz_podcasters set 
podcaster_url = 'http://atomix.vg/', 
podcaster_short_description = 'Todo sobre videojuegos y entretenimiento',
podcaster_avatar = 'http://www.neotokyo.vg/wp-content/uploads/2013/06/atomix_new_logo.png'
where podcaster_id = 17;


select * from pdz_tracks order by track_id desc;

-- select * from pdz_tracks order by track_id desc;
-- delete from pdz_tracks where track_id = 219;
-- update pdz_podcasts set podcast_last_act = '2017-08-15 00:00:00' where podcast_id = 16;
select * from pdz_podcasts order by podcast_id;
/* update pdz_podcasts set podcast_artwork = 'images\\capitan-pada.png' where podcast_id = 1;
update pdz_podcasts set podcast_artwork = 'images\\comic-geekos.jpg' where podcast_id = 2;
update pdz_podcasts set podcast_artwork = 'images\\desde-abajo.jpg' where podcast_id = 3;
update pdz_podcasts set podcast_artwork = 'images\\comicverso.jpg' where podcast_id = 4;
update pdz_podcasts set podcast_artwork = 'images\\comikaze.jpg' where podcast_id = 5;
update pdz_podcasts set podcast_artwork = 'images\\cafe-comiquero.jpg' where podcast_id = 6;
update pdz_podcasts set podcast_artwork = 'images\\superweyes.jpg' where podcast_id = 7;
update pdz_podcasts set podcast_artwork = 'images\\dstripando.jpg' where podcast_id = 8;
update pdz_podcasts set podcast_artwork = 'images\\comicmania.jpg' where podcast_id = 9;
update pdz_podcasts set podcast_artwork = 'images\\los-forasteros.jpg' where podcast_id = 10;
update pdz_podcasts set podcast_artwork = 'images\\cueva-nerd.jpg' where podcast_id = 11;
update pdz_podcasts set podcast_artwork = 'images\\noob-news.jpg' where podcast_id = 12;
update pdz_podcasts set podcast_artwork = 'images\\no-sekai.jpg' where podcast_id = 13;
update pdz_podcasts set podcast_artwork = 'images\\frikipodcast.jpg' where podcast_id = 14;
update pdz_podcasts set podcast_artwork = 'images\\sayonara.jpg' where podcast_id = 15;
update pdz_podcasts set podcast_artwork = 'images\\atomix.jpg' where podcast_id = 17; */
