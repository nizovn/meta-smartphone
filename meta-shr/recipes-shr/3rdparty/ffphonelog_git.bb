DESCRIPTION = "Finger friendly phonelog"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
HOMEPAGE = "http://www.opkg.org/package_343.html"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://ffphonelog.vala;endline=16;md5=37b136bcd8f47e0d65fcaf815b61db75"
DEPENDS = "libeflvala"
RDEPENDS_${PN} = "phoneuid"
PV = "0.1+gitr${SRCPV}"
PR = "r2"

SRC_URI = "\
	git://git.shr-project.org/repo/ffphonelog.git;protocol=http;branch=master \
	file://0001-fix-name-of-changed-genlist-gengrid-callbacks.patch \
"

export XDG_DATA_DIRS = "${STAGING_DATADIR}"

SRCREV = "d4f4fdf582af2da0c971c7124a0c843da2567d38"
S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/applications ${datadir}/pixmaps"

EXTRA_OEMAKE = " \
	CC='${CC}' \
	CFLAGS_APPEND='${CFLAGS}' \
	LDFLAGS_APPEND='${LDFLAGS}' \
	DESTDIR='${D}' \
	PREFIX=/usr"

do_install() {
       oe_runmake install
}

MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
