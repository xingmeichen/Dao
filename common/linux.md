# Linux

## Base64
### decode
echo {your_encrypted_text} | base64 -d

## Compare
diff {folder1} {folder2}
diff {file1} {file2}

## netstat
### netstat -ano
### netstat -aon | findstr "{your_port}"

## kill
taskkill -pid {pid} -f

## curl
eg.
curl -k -vv --proxy {proxy_host}:{proxy_port} --location --request \
POST "{request_url}" \
--header 'Authorization: Basic xxxxxxx' \
--header 'Content-Length: 0' \
--header 'Content-Type: application/json'
