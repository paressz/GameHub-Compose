package com.farez.gamehub_compose.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game implements Serializable {
    @ColumnInfo(name = "nama")
    String nama;
    @ColumnInfo(name = "cpu")
    String cpu;
    @ColumnInfo(name = "ram")
    int ram;
    @ColumnInfo(name = "hdd")
    int hdd;
    @ColumnInfo(name = "vga")
    String vga;
    @ColumnInfo(name = "deskripsi")
    String deskripsi;
    @ColumnInfo(name = "imageUrl")
    String imageUrl;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "isGameDewasa")
    boolean isGameDewasa;


    public Game(String nama, String cpu, int ram, int hdd, String vga, String deskripsi, String imageUrl, boolean isGameDewasa) {
        this.nama = nama;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.vga = vga;
        this.deskripsi = deskripsi;
        this.imageUrl = imageUrl;
        this.isGameDewasa = isGameDewasa;
    }

    //GETTER AND SETTER BUAT SEMUA PROPERTI KECUALI ID

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isGameDewasa() {
        return isGameDewasa;
    }

    public void setGameDewasa(boolean gameDewasa) {
        isGameDewasa = gameDewasa;
    }


    //DATA UNTUK DIMASUKKAN KE  DATABASE

    public static List<Game> sampleGameList() {
        List<Game> list = new ArrayList<>();
        String steamUrl = "https://cdn.cloudflare.steamstatic.com/steam/apps/";
        list.add(new GameBuilder().setNama("League of Legends").setCpu("Intel Core i3-530 / AMD A6-3650").setRam(4).setHdd(16).setVga("Nvidia GeForce 9600GT / AMD Radeon HD 6570 / Intel HD 4600 Integrated Graphics").setDeskripsi("League of Legends, commonly referred to as League, is a 2009 multiplayer online battle arena video game developed and published by Riot Games. Inspired by Defense of the Ancients, a custom map for Warcraft III, Riot's founders sought to develop a stand-alone game in the same genre.").setImageUrl("https://www.leagueoflegends.com/static/logo-1200-04b3cefafba917c9c571f9244fd28a1e.png").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Counter Strike 2").setCpu("Intel Core i5-750").setRam(8).setHdd(85).setVga("Any GPU type but need at least 1gb or more vram").setDeskripsi("For over two decades, Counter-Strike has offered an elite competitive experience, " + "one shaped by millions of players from across the globe. And now the next chapter in the CS " + "story is about to begin. This is Counter-Strike 2.").setImageUrl(steamUrl + "730/header.jpg?t=1696359298").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("The Sims™ 4").setCpu("Intel Core i3-3220 / AMD Ryzen 3 1200").setRam(4).setHdd(26).setVga("Any GPU type but need at least 128mb of vram").setDeskripsi("Play with life and discover the possibilities. Unleash your imagination and create a world of Sims that’s wholly unique. Explore and customize every detail from Sims to homes–and much more.").setImageUrl(steamUrl + "1222670/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Apex Legends™").setCpu("Intel Core i3 6300 / AMD FX 4350").setRam(6).setHdd(56).setVga("AMD Radeon™ HD 7730, NVIDIA GeForce® GT 640").setDeskripsi("Apex Legends is the award-winning, free-to-play Hero Shooter from Respawn Entertainment." + " Master an ever-growing roster of legendary characters with powerful abilities, and " + "experience strategic squad play and innovative gameplay in the next evolution of Hero Shooter" + " and Battle Royale.").setImageUrl(steamUrl + "1172470/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Team Fortress 2").setCpu("Intel Pentium 4 or AMD Phenom").setRam(1).setHdd(15).setVga("Any GPU type but need at least 512gb of vram").setDeskripsi("Nine distinct classes provide a broad range of tactical abilities and personalities. " + "Constantly updated with new game modes, maps, equipment and, most importantly, hats!").setImageUrl(steamUrl + "440/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("PUBG: BATTLEGROUNDS").setCpu("Intel Core i5-4430 / AMD FX-6300").setRam(8).setHdd(40).setVga("NVIDIA GeForce GTX 960 2GB / AMD Radeon R7 370 2GB").setDeskripsi("Play PUBG: BATTLEGROUNDS for free.\n" + "Land on strategic locations, loot weapons and supplies, and survive to become the last team " + "standing across various, diverse Battlegrounds.\n" + "Squad up and join the Battlegrounds for the original Battle Royale experience that only " + "PUBG: BATTLEGROUNDS can offer.").setImageUrl(steamUrl + "578080/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("War Thunder").setCpu("Intel Core i5 or Ryzen 5 3600").setRam(4).setHdd(95).setVga("Nvidia GeForce 1060, Radeon RX 570").setDeskripsi("War Thunder is the most comprehensive free-to-play, cross-platform, MMO military game " + "dedicated to aviation, armoured vehicles, and naval craft, from the early 20th century to the" + " most advanced modern combat units. Join now and take part in major battles on land, in the " + "air, and at sea.").setImageUrl(steamUrl + "236390/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("World of Warships").setCpu("Intel® Core™ i3-3210 @ 3.2GHz, AMD Athlon™ II X2 245 @ 2.9 GHz").setRam(6).setHdd(61).setVga("NVIDIA® GeForce® GT 640, AMD Radeon™ R7 240, Intel® HD 4000").setDeskripsi("Immerse yourself in thrilling naval battles and assemble an armada of over 600 ships from the first half of the 20th century — from stealthy destroyers to gigantic battleships. Change the look of your ship, choose upgrades to suit your play style, and go into battle with other players!").setImageUrl(steamUrl + "552990/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("GTA V").setCpu("Intel Core 2 Quad CPU Q6600 / AMD Phenom 9850").setRam(4).setHdd(72).setVga("NVIDIA 9800 GT 1GB / AMD HD 4870 1GB").setDeskripsi("Grand Theft Auto V for PC offers players the option to explore the award-winning world of Los " + "Santos and Blaine County in resolutions of up to 4k and beyond, as well as the chance to experience the " + "game running at 60 frames per second.").setImageUrl(steamUrl + "271590/header.jpg").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("DARK SOULS™: REMASTERED").setCpu("Intel Core i5-2300 2.8 GHz / AMD FX-6300, 3.5 GHz").setRam(6).setHdd(8).setVga(" GeForce GTX 460, 1 GB / Radeon HD 6870, 1 GB").setDeskripsi("Then, there was fire. Re-experience the critically acclaimed, genre-defining game that " + "started it all. Beautifully remastered, return to Lordran in stunning high-definition detail " + "running at 60fps.").setImageUrl(steamUrl + "570940/header.jpg").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("No Man's Sky").setCpu("Intel Core i3").setRam(8).setHdd(15).setVga("Nvidia GTX 1060 3GB/ AMD RX 470 4GB/ Intel UHD graphics 630").setDeskripsi("No Man's Sky adalah game tentang eksplorasi dan kelangsungan hidup di alam semesta yang dihasilkan secara prosedural tanpa batas.").setImageUrl(steamUrl + "275850/header.jpg?t=1692895292").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Cyberpunk 2077").setCpu("Core i7-6700 / Ryzen 5 1600 / Core i7-12700 / Ryzen 7 7800X3D").setRam(12).setHdd(70).setVga(" GeForce GTX 1060 6GB / Radeon RX 580 8GB / Arc A380  / GeForce GTX 1060 6GB / Radeon RX 580 8GB / Arc A380").setDeskripsi("Cyberpunk 2077 adalah RPG aksi petualangan dunia terbuka yang berlatar masa depan gelap Night City, kota metropolitan berbahaya yang terobsesi dengan kekuatan, glamor, dan modifikasi tubuh tanpa henti.").setImageUrl(steamUrl + "1091500/header_alt_assets_2.jpg?t=1695308476").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("ELDEN RING").setCpu("Intel Core i5-8400 / AMD ryzen 3 3300X").setRam(12).setHdd(60).setVga(" NVIDIA GEFORCE GTX 1060 3 GB / AMD RADEON RX 580 4 GB").setDeskripsi("RPG AKSI FANTASI BARU. Bangkit, Ternoda, dan dibimbing oleh rahmat untuk mengacungkan kekuatan Cincin Elden dan menjadi Raja Elden di Negeri Antara.").setImageUrl(steamUrl + "1245620/header.jpg?t=1683618443").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Forza Motorsport").setCpu(" Intel i5-8400 / AMD Ryzen 5 1600").setRam(8).setHdd(130).setVga("NVidia GTX 1060 / AMD RX 5500 XT").setDeskripsi("Kalahkan kompetisi dalam karier yang serba baru. Balapan teman Anda dalam acara multipemain yang dinilai. Bersaing dengan lebih dari 500 mobil di trek terkenal di dunia dengan AI mutakhir, fisika canggih, serta strategi ban dan bahan bakar.").setImageUrl(steamUrl + "2440510/header_alt_assets_1.jpg?t=1696625580").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Hunt: Showdown").setCpu("Intel i5-4590 / AMD Ryzen 3 1200").setRam(8).setHdd(50).setVga("NVIDIA GeForce GTX 660 TI / AMD Radeon R7 370").setDeskripsi("Hunt: Showdown adalah game tembak-menembak orang pertama PvPvE taktis dan berisiko tinggi. Berburu hadiah di Bayou yang penuh, bunuh monster-monster mimpi buruk, dan kalahkan pemburu pesaing - sendirian atau berkelompok - dengan mempertaruhkan kemuliaan, perlengkapan,").setImageUrl(steamUrl + "594650/header_alt_assets_19.jpg?t=1696522186").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Mortal Kombat 1").setCpu("Intel Core i5-6600 / AMD Ryzen 3 3100 / Ryzen 5 2600").setRam(8).setHdd(100).setVga("Nvidia GeForce GTX 980 / AMD Radeon RX 470 / Intel Arc A750").setDeskripsi("Temukan Alam Semesta Mortal Kombat yang terlahir kembali yang diciptakan oleh Dewa Api Liu Kang. Mortal Kombat 1 mengantarkan era baru dari franchise ikonik dengan sistem pertarungan, mode permainan, dan korban jiwa baru!").setImageUrl(steamUrl + "1971870/header.jpg?t=1696436825").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Rust").setCpu("Intel Core i7-3770 / AMD FX-9590").setRam(10).setHdd(25).setVga("GTX 670 2GB / AMD R9 280").setDeskripsi("Satu-satunya tujuan di Rust adalah untuk bertahan hidup. Semuanya ingin Anda mati - satwa liar di pulau itu dan penghuni lainnya, lingkungan, dan para penyintas lainnya. Lakukan apa pun untuk bertahan satu malam lagi.").setImageUrl(steamUrl + "252490/header.jpg?t=1693652810").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Lies of P").setCpu("Intel Core i3-6300 / AMDRyzen 3 1200").setRam(8).setHdd(50).setVga("AMD Radeon RX 560 4GB / NVIDIA GeForce GTX 960 4GB").setDeskripsi("Lies of P adalah film berjiwa mendebarkan yang mengambil kisah Pinokio, memutar kepalanya, dan menempatkannya dengan latar belakang era Belle Epoque yang sangat elegan.").setImageUrl(steamUrl + "1627720/header.jpg?t=1696396720").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("EA SPORTS FC 24").setCpu("Intel Core i5-6600K 3.50GHz / AMD Ryzen 5 1600  3.2 GHZ").setRam(8).setHdd(100).setVga("NVIDIA GeForce GTX 1050 Ti 4GB / AMD Radeon RX 570 4GB").setDeskripsi("EA SPORTS FC 24 menyambut Anda di The World's Game: pengalaman sepak bola paling nyata yang pernah ada dengan HyperMotionV, PlayStyles yang dioptimalkan oleh Opta, dan Frostbite Engine yang disempurnakan.").setImageUrl(steamUrl + "2195250/header.jpg?t=1696300539").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("The Witcher 3: Wild Hunt").setCpu(" Intel CPU Core i5-2500K 3.3GHz / AMD A10-5800K APU 3.8GHz").setRam(6).setHdd(50).setVga("Nvidia GPU GeForce GTX 660 / AMD GPU Radeon HD 7870").setDeskripsi("Anda adalah Geralt dari Rivia, pembunuh monster tentara bayaran. Sebelum Anda berdiri di benua yang dilanda perang dan dipenuhi monster, Anda dapat menjelajah sesuka hati. Kontrak Anda saat ini? Melacak Ciri — Anak Nubuat, senjata hidup yang dapat mengubah bentuk dunia.").setImageUrl(steamUrl + "292030/header.jpg?t=1693590732").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("New World").setCpu("Intel Core i5-10500 3.10GHz / AMD Ryzen 3 3300X").setRam(8).setHdd(100).setVga("NVIDIA GeForce GTX 1060 3GB / AMD Radeon RX 590").setDeskripsi("Jelajahi MMO dunia terbuka yang mendebarkan yang penuh dengan bahaya dan peluang di mana Anda akan menempa takdir baru di pulau supernatural Aeternum.").setImageUrl(steamUrl + "1063730/header.jpg?t=1695753023").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Stumble Guys").setCpu(" Intel Core 2 Duo E8400 / AMD Phenom II X4 965").setRam(4).setHdd(1).setVga("AMD Radeon HD 7750 / NVIDIA Geforce GTX 2600").setDeskripsi("Berlomba melalui rintangan melawan hingga 32 pemain online. Berlari, lompat, dan lari ke garis finis hingga pemain terbaik merebut mahkota!").setImageUrl(steamUrl + "1677740/header.jpg?t=1696588681").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("HOT WHEELS UNLEASHED™ 2 - Turbocharged").setCpu("Intel Core i5-4590 / AMD FX-4350").setRam(8).setHdd(30).setVga("GeForce GTX 1050 / Radeon RX 460").setDeskripsi("Lomba mobil tercanggih telah kembali dan membawa keseruan ke level selanjutnya! Lebih dari 130 mobil dengan montir baru dan tipe kendaraan lebih banyak! Bangun jalurmu dengan lingkungan baru yang menakjubkan dan mode berbeda untuk bergembira secara daring dan luring!").setImageUrl(steamUrl + "2051120/header.jpg?t=1694793100").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Red Dead Redemption 2").setCpu("Intel Core i7-4770K / AMD Ryzen 5 1500X").setRam(12).setHdd(150).setVga("Nvidia GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB").setDeskripsi("Pemenang lebih dari 175 Game of the Year Awards dan penerima lebih dari 250 skor sempurna, RDR2 adalah kisah epik penjahat Arthur Morgan dan geng Van der Linde yang terkenal, dalam pelarian melintasi Amerika pada awal zaman modern. Juga termasuk akses ke dunia kehidupan bersama Red!").setImageUrl(steamUrl + "1174180/header.jpg?t=1695140956").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("Resident Evil 4").setCpu("AMD Ryzen 3 1200/Intel Core i5-7500").setRam(8).setHdd(60).setVga("AMD Radeon RX 560 with 4GB VRAM / NVIDIA GeForce GTX 1050 Ti with 4GB VRAM").setDeskripsi("Kelangsungan hidup hanyalah permulaan. Enam tahun telah berlalu sejak bencana biologis di Raccoon City. Leon S. Kennedy, salah satu yang selamat, melacak putri presiden yang diculik ke sebuah desa terpencil di Eropa, di mana ada sesuatu yang tidak beres dengan penduduk setempat.").setImageUrl(steamUrl + "2050650/header_alt_assets_0.jpg?t=1696242724").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("Marvel’s Spider-Man: Miles Morales").setCpu("Intel Core i3-4160 3.6 GHz / AMD equivalent").setRam(8).setHdd(75).setVga("NVIDIA GTX 950 / AMD Radeon RX 470").setDeskripsi("Setelah peristiwa Marvel's Spider-Man Remastered, remaja Miles Morales menyesuaikan diri dengan rumah barunya sambil mengikuti jejak mentornya, Peter Parker, sebagai Spider-Man baru. Ketika perebutan kekuasaan yang sengit mengancam untuk menghancurkan rumahnya").setImageUrl(steamUrl + "1817190/header.jpg?t=1695916167").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("The Last of Us Part I").setCpu("AMD Ryzen 5 1500X / Intel Core i7-4770K").setRam(16).setHdd(100).setVga("AMD Radeon RX 470 (4 GB) / AMD Radeon RX 6500 XT (4 GB) / NVIDIA GeForce GTX 970 (4 GB) / NVIDIA GeForce GTX 1050 Ti (4 GB)").setDeskripsi("Rasakan kisah emosional dan karakter tak terlupakan dalam The Last of Us™, pemenang lebih dari 200 penghargaan Game of the Year.").setImageUrl(steamUrl + "1888930/header.jpg").setIsGameDewasa(true).createGame());
        list.add(new GameBuilder().setNama("Sekiro : Shadows Die Twice - GOTY Edition").setCpu("Intel Core i3-2100 / AMD FX-6300").setRam(4).setHdd(25).setVga("NVIDIA GeForce GTX 760 / AMD Radeon HD 7950").setDeskripsi("Game Terbaik Tahun Ini - The Game Awards 2019 Game Aksi Terbaik 2019 - IGN Ciptakan jalan cerdas Anda sendiri untuk membalas dendam dalam petualangan pemenang penghargaan dari pengembang FromSoftware, pencipta seri Bloodborne dan Dark Souls. Membalas dendam....").setImageUrl(steamUrl + "814380/header.jpg?t=1678991267").setIsGameDewasa(false).createGame());
        list.add(new GameBuilder().setNama("Call of Duty: Black Ops III").setCpu(" Intel Core i3-530 2.93 GHz / AMD Phenom II X4 810 2.60 GHz").setRam(6).setHdd(100).setVga("NVIDIA GeForce GTX 470 1GB / ATI Radeon HD 6970 1GB").setDeskripsi("Call of Duty®: Black Ops III Zombies Chronicles Edition mencakup game dasar lengkap ditambah perluasan konten Zombies Chronicles.").setImageUrl(steamUrl + "311210/header.jpg?t=1646763462").setIsGameDewasa(false).createGame());
        return list;
    }
}
