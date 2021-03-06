SUMMARY = "OpenGL driver testing framework"
LICENSE = "MIT & LGPLv2+ & GPLv3 & GPLv2+ & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=b2beded7103a3d8a442a2a0391d607b0"

SRC_URI = "git://anongit.freedesktop.org/piglit \
           file://0001-tests-Fix-missing-include-of-Xutil.h.patch"

# From 2014/12/04
SRCREV = "126c7d049b8f32e541625d5a35fbc5f5e4e7fbf8"
# (when PV goes above 1.0 remove the trailing r)
PV = "1.0+gitr${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "virtual/libx11 libxrender waffle virtual/libgl libglu python-mako-native python-numpy-native"

inherit cmake pythonnative distro_features_check
# depends on virtual/libx11
REQUIRED_DISTRO_FEATURES = "x11"

PACKAGECONFIG ??= ""
PACKAGECONFIG[freeglut] = "-DPIGLIT_USE_GLUT=1,-DPIGLIT_USE_GLUT=0,freeglut,"

FILES_${PN}-dbg += "${libdir}/piglit/*/.debug/"

RDEPENDS_${PN} = "waffle python python-mako python-json python-subprocess \
	python-argparse python-importlib python-unixadmin \
	python-multiprocessing python-textutils python-netserver python-shell \
	mesa-demos bash \
	"

INSANE_SKIP_${PN} += "dev-so"
