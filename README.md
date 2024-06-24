1. clone 之後 docker-compose up -d 啟動資料庫
2. 啟動後flyway會自動建立資料庫與 init data
3. 因為沒有實作登入，所以新增訂單時直接帶入uid，查詢也是
