## Intro

You can generate a non-signed debian package via:

```bash
debuild -us -uc -b
```
in the parent of this directory. This will generate the deb file in the parent directory of this repository.

## Testing

You can test the generated package without installit with `piuparts` like:

```bash
sudo piuparts -D ubuntu -d xenial -d bionic ../ala-collectory_1.6.2-1_all.deb
```
in this way you can also test it in different releases.

Read `/usr/share/doc/piuparts/README.*` for more usage samples.

## No interactive install

You can preseed this package with something similar to (if this package uses mysql):

```bash
echo "ala-collectory ala-collectory/mysql/admin-pass password $DB_ROOT_PWD" | debconf-set-selections && \
echo "ala-collectory ala-collectory/dbconfig-install boolean true" | debconf-set-selections && \
echo "ala-collectory ala-collectory/dbconfig-upgrade boolean true" | debconf-set-selections

cat > /etc/dbconfig-common/ala-collectory.conf <<EOF
dbc_dbname='collectory'
dbc_dbuser='collectory'
dbc_dbpass='password'
EOF

export DEBCONF_FRONTEND=noninteractive
apt-get install -yq --force-yes ala-collectory
```
