## Certification management
### To list all cert
keytool --list -keystore {your_cert_stock_file.jks} -storepass {your_cert_stock_file_password}
eg.
keytool --list -keystore ./truststore.jks -storepass abc123456

### To add cert
keytool -keystore {your_cert_stock_file.jks} -import -alias {your_cert_alias} -file {your_cert_full_path} -storepass {your_cert_store_file_password}
eg.
keytool -keystore ./truststore.jks -import alias com.dao -file ./dao.crt -storepass abc123456

### To search specific cert
keytool -list -keystore {your_cert_stock_file.jks} -alias {yor_cert_alias} -storepass {your_cert_store_file_password}
eg.
keytool -list -keystore ./truststore.jks -alias com.dao -storepass abc123456

### To delete specific cert
keytool -delete -alias {your_cert_alias} -keystore {your_cert_stock_file.jks} -storepass {your_cert_store_file_password}
eg.
keytool -delete -alias com.dao -keystore ./truststore.jks -storepass abc123456